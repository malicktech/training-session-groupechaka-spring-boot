package com.chaka.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.chaka.demo.domain.User;

//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByLastName(String name);

	// @RestResource(path = "by-email")

	User findByEmail(String email);

}
