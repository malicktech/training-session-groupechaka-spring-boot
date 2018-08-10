package com.chaka.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaka.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByLastName(String name);
	
}
