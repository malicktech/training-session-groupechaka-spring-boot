package com.chaka.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaka.demo.domain.Role;

/**
 * Spring Data JPA repository for the Authority entity.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}