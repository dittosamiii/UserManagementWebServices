package com.springboot.userdto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Schema(description = "UserDto Model Information")
public class UserDto {
	
	@Schema(description = "User ID")
	private Long id;
	
	@Schema(description = "User First Name")
	@NotEmpty(message = "FirstName Field should not be empty.")
	private String firstName;
	
	@Schema(description = "User Last Name")
	@NotEmpty(message = "LastName Field should not be empty.")
	private String lastName;
	
	@Schema(description = "User Email")
	@NotEmpty(message = "Email Field should not be empty.")
	@Email(message = "Enter a Valid Email.")
	private String email;

	public UserDto() {
		super();
	}

	public UserDto(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
