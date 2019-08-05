package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.api.User;
import com.demo.persistence.UserRepository;

@Service
public class UserServiceImp implements UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImp (UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	
	public List<User> findAllUsuarios() {
//		User user = new User();
//		user.setName("JuanDiegoCarechimba");
//		user.setId(23);
//		return Arrays.asList(user);
		return userRepository.findAll();
	}

}
