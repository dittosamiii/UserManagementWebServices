package com.springboot.service;

import java.util.List;

import com.springboot.userdto.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);

	UserDto getUserById(Long id);

	List<UserDto> getAllUsers();

	UserDto updateUser(UserDto user);
	
	UserDto deleteUser(Long id);
}
