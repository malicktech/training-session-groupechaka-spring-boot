package com.chaka.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.chaka.demo.domain.Role;
import com.chaka.demo.domain.User;
import com.chaka.demo.repository.RoleRepository;
import com.chaka.demo.repository.UserRepository;

/**
 * Interface dans spring boot qui permet d'Exécuter du code au démarrage de
 * l'application spring boot
 * 
 * @author citizendiop
 */
@Component
public class DemoStartupCommandLineRunner implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private UserRepository userRepository;
	private RoleRepository roleRepository;

	private static final String USER_PASSWORD_ENCODE = "$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K";
	private static final String USER_ADMIN_ENCODE = "$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC";

	private Set<Role> roles = new HashSet<>();

	public DemoStartupCommandLineRunner(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("-------------------------------");
		log.info("Application started with command-line arguments: {}", Arrays.toString(args));
		log.info("-------------------------------\n ");

		/**
		 * Test Spring data japa
		 */

		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");
		roleRepository.save(userRole);
		roleRepository.save(adminRole);

		roles.addAll(roleRepository.findAll());

		// save users
		userRepository.save(new User("Jack", "Bauer", LocalDate.of(1950, Month.JANUARY, 1), "jack-bauer@gmail.com",
				USER_PASSWORD_ENCODE, roles));
		userRepository.save(new User("Chloe", "O'Brian", LocalDate.of(1975, Month.MARCH, 1), "chloe-brian@gmail.com",
				USER_PASSWORD_ENCODE, roles));
		userRepository.save(new User("Kim", "Bauer", LocalDate.of(1990, Month.DECEMBER, 1), "kim-bauer@gmail.com",
				USER_PASSWORD_ENCODE, roles));
		userRepository.save(new User("David", "Palmer", LocalDate.of(2000, Month.AUGUST, 1), "david-palmer@gmail.com",
				USER_PASSWORD_ENCODE, roles));
		// fetch all users
		log.info("User found with findAll():");
		log.info("-------------------------------");
		userRepository.findAll().forEach(u -> log.info(u.toString()));
		log.info("");

		// fetch an individual user by ID
		userRepository.findById(1L).ifPresent(customer -> {
			log.info("User found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");
		});

		// fetch user by last name
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		userRepository.findByLastName("Bauer").forEach(u -> log.info(u.toString()));
		log.info("");
	}

}
