package com.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.api.User;
import com.demo.service.UserService;

@RestController("/")
public class UserAPI implements UserAPISpec {

	private final UserService userService;

	@Autowired
	public UserAPI(UserService userService) {
		this.userService = userService;

	}

	@GetMapping("user")
	public ResponseEntity<List<User>> findAllUsers() {
//		User user = new User();
//		user.setName("JuanDiegoCarechimba");
//		user.setId(23);
		
		

//		return new ResponseEntity<List<User>>(Arrays.asList(user), HttpStatus.OK);
		return new ResponseEntity<List<User>>(userService.findAllUsuarios(), HttpStatus.OK);
	}

}
