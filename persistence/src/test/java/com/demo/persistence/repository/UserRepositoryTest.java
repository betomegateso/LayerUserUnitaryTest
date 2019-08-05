package com.demo.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.model.api.User;
import com.demo.persistence.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setupDB() {
//		List<User> listUser = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
//			listUser.add(new User("User_" + i, i));

			testEntityManager.persist(new User("User_" + i, i));
		}

//		userRepository.saveAll(listUser);
	}

	@Test
	public void findAllUserTest() {
		List<User> listUser = userRepository.findAll();

		assertThat(listUser).isNotNull();
		assertThat(listUser.size()).isEqualTo(100);

	}
	
	@Test
	public void findUserTest() {
		Optional<User> user = userRepository.findById(1000);
		
//		assertThat(user.get()).isNotNull();
		
//		assertTrue(user.isPresent());
		assertFalse(user.isPresent());
//		assertThat(listUser.size()).isEqualTo(100);
		
	}

}
