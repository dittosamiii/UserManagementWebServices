package com.springboot.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.exception.EmailAlreadyExistsException;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.repository.UserRepository;
import com.springboot.service.UserService;
import com.springboot.userdto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;

	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		super();
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserDto createUser(UserDto userDto) {

//		User savedUser = UserMapper.mapToUser(userDto);
		Optional<User> user = userRepository.findByEmail(userDto.getEmail());
		if (user.isPresent()) {
			throw new EmailAlreadyExistsException("Email_already_exists");
		}

		User savedUser = modelMapper.map(userDto, User.class);
		userRepository.save(savedUser);

//		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
//		return UserMapper.mapToUserDto(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
//		return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId()));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User savedUser = userRepository.save(existingUser);
//		return UserMapper.mapToUserDto(savedUser);
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto deleteUser(Long id) {
		User deletedUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userRepository.deleteById(id);
//		return UserMapper.mapToUserDto(deletedUser);
		return modelMapper.map(deletedUser, UserDto.class);
	}
}
