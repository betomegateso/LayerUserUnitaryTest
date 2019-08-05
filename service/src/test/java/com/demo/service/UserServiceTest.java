package com.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.model.api.User;
import com.demo.persistence.UserRepository;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@MockBean
	private  UserRepository userRepository;
	
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public UserServiceImp userService(UserRepository userRepository) {
            return new UserServiceImp(userRepository);
        }
    }
	
	@Autowired
	private UserServiceImp userService;

	@Test
	public void findAllUsersTest() {
		
		when(userRepository.findAll()).thenReturn(Arrays.asList(new User("pedro",1000)));
		
		List<User> user = userService.findAllUsuarios();
		
		assertThat(user).isNotNull();
		assertThat(user.size()).isEqualTo(1);
		assertThat(user.get(0).getName()).isEqualTo("pedro");
		assertThat(user.get(0).getId()).isEqualTo(1000);
	

	}

}
