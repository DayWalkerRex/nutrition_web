package com.example.demo.controller.dto;

public class LoginResponseDto {
	private String jwt;
	
	private boolean succes;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public boolean isSucces() {
		return succes;
	}

	public void setSucces(boolean succes) {
		this.succes = succes;
	}
}
