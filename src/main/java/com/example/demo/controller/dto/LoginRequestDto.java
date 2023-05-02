package com.example.demo.controller.dto;

import com.example.demo.entity.Users;

public class LoginRequestDto {
	private String email;
	
	private String password;
	
	public Users toUsers() {
		Users user = new Users();
		user.setEmail(email);
		user.setPassword(password);
		return user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
