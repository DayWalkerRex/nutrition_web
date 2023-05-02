package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.SignupRequestDto;
import com.example.demo.entity.Users;
import com.example.demo.repository.IUsersRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthService {
	@Autowired
	private IUsersRepository usersRepo;
	
	private static final long jwtExpirationInMs = 86400000; // 1 day
	
	public boolean validate(String email, String password) {
		if(usersRepo.findByEmailAndPassword(email, password).isEmpty())
			return false;
		
		return true;
	}
	
	public boolean validate(String email) {
		if(usersRepo.findByEmail(email).isEmpty())
			return false;
		
		return true;
	}
	
	public String signup (SignupRequestDto dto) {
		Users user = new Users();
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//String encryptedPassword = passwordEncoder.encode(dto.getPassword());
	
		user = dto.toUsers();
		//user.setPassword(encryptedPassword);
		
		//Check if user already exist
		if(validate(user.getEmail()))
			return "E-mail is already taken";
		
		this.usersRepo.save(user);
		return "User was succesfully added";
	}
	
	public String generateJwtToken(Users user) {
	    Date now = new Date();
	    Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
	    
	    String secretKey = "brownricebrocollichickpeascashewnuts";

	    String temp = Jwts.builder()
	            .setSubject(Long.toString(user.getId()))
	            .claim("roles", user.getRole().name())
	            .setIssuedAt(now)
	            .setExpiration(expiryDate)
	            .signWith(SignatureAlgorithm.HS512, secretKey)
	            .compact();
	    
	    System.out.println(temp);
	    
	    return temp;
	}
}
