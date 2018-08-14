package com.chaka.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaka.demo.domain.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
