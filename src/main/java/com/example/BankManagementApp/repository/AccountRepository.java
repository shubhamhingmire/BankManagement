package com.example.BankManagementApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankManagementApp.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

	
}
