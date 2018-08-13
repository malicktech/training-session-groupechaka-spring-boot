package com.chaka.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chaka.demo.domain.User;
import com.chaka.demo.repository.UserRepository;

/**
 * @DataJpaTest provides some standard setup needed for testing the persistence
 *              layer:
 * 
 *              configuring H2, an in-memory database
 * 
 *              setting Hibernate, Spring Data, and the DataSource
 * 
 *              performing an @EntityScan
 * 
 *              turning on SQL logging
 * 
 * @author citizendiop
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void findByLastName() throws Exception {
		User savedUser = userRepository.save(new User("Stephan", "Nicolle", LocalDate.of(2000, Month.JANUARY, 1)));
		Optional<User> retrievedUser = userRepository.findById(1L);
		assertThat(retrievedUser.get().getId().equals(savedUser.getId()));
	}

	@Test
	public void whenFindByLastName_thenReturnUser() {
		User userSaved = userRepository.save(new User("Stephan", "Nicolle", LocalDate.of(2000, Month.JANUARY, 1)));
		User userFound = userRepository.findByLastName(userSaved.getLastName()).get(0);
		assertThat(userFound.getLastName()).isEqualTo(userSaved.getLastName());
	}
}
