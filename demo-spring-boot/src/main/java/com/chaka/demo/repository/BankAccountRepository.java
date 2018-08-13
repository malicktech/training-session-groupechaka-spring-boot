package com.chaka.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaka.demo.domain.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

}
