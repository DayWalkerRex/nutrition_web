package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge=3600)
//@RequestMapping("api/auth")
public class UsersController {
	/*@Autowired
	private AuthService authService;
	
	@RequestMapping("signup")
	public void signup(@RequestBody SignupRequestDto dto) {
		String message = authService.signup(dto);
	}*/
	
	/*@PostMapping("login")
	public String login(@Valid @RequestBody Users user) {
		return authService.generateJwtToken(user);
	}*/
	
	@RequestMapping("logins")
	public ResponseEntity<?> logins() {
		return ResponseEntity.ok("yes");
	}
}
