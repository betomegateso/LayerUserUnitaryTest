package com.demo.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.model.api.User;

public interface UserAPISpec {
	
	public ResponseEntity<List<User>> findAllUsers();

}
