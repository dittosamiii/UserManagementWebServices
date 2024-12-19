package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.UserService;
import com.springboot.userdto.UserDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "CRUD REST APIs for User Resource", description = "CRUD REST APIs - Create User, Update User, Get User By Id, Get All Users, Delete User")
@RestController
@RequestMapping("api/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@Operation(summary = "Create User REST API", description = "Create User REST API is used to save user in database")
	@ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@Operation(summary = "Get User By ID REST API", description = "Get User By ID REST API is used to get a single user from the database")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
		UserDto user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

	@Operation(summary = "Get All Users REST API", description = "Get All Users REST API is used to get all the users from the database")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}

	@Operation(summary = "Update User REST API", description = "Update User REST API is used to update a particular user in the database")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto user) {
		user.setId(id);
		return ResponseEntity.ok(userService.updateUser(user));
	}
	
	@Operation(summary = "Delete User REST API", description = "Delete User REST API is used to delete a particular user from the database")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
	@DeleteMapping("{id}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
		UserDto user = userService.deleteUser(id);
		return ResponseEntity.ok(user);
	}

//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//			WebRequest webRequest) {
//		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), webRequest.getDescription(false),
//				exception.getMessage(), "USER_NOT_FOUND");
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//	}
}
