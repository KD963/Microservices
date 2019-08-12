package com.bridgelabz.user.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO {

	@NotNull
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	@NotNull
//	@NotEmpty(message = "email id should not be empty")
//	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
	private String email;
	@NotNull
//	@NotEmpty(message = "phone number should not be empty")
//	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}")
	private String phone;
	@NotNull
//	@NotEmpty(message = "password should not be empty")
//	@Pattern(regexp = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})")
	private String password;

	public UserDTO() {

	}

	public UserDTO(String name, String email, String phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
