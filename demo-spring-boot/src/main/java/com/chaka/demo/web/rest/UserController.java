package com.chaka.demo.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chaka.demo.domain.User;
import com.chaka.demo.repository.UserRepository;

@RestController
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/all-users")
	private List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users-from-name/{name}")
	private List<User> getUsersFromName(@PathVariable String name) {
		return userRepository.findByLastName(name);
	}
}
