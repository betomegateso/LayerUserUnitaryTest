package com.demo.api.runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.model.api.User;
import com.demo.persistence.UserRepository;

@Component
public class UserRunner implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public void run(String... args) throws Exception {

		System.out.println("poblando base");
		
		List<User> listUser = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			listUser.add(new User("User_" + i, i));
		}
		
		
		userRepository.saveAll(listUser);
		
		System.out.println("poblando");

	}

}
