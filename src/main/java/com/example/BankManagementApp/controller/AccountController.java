package com.example.BankManagementApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankManagementApp.entity.Account;
import com.example.BankManagementApp.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createAccount = service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}

	@GetMapping("/{accountNumber}")
	public Account getAccountByAccountNumber(@PathVariable Long accountNumber) {
		Account account=service.getAccountDetailsByAccountNumber(accountNumber);
		return account;
	}
	
	@GetMapping("/getallaccounts")
	public List<Account> getAllAccountDetails(){
		List<Account> allAccountDetails=service.getAllAccountDetails();
		return allAccountDetails;
		}
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public Account depositAccount(Long accountNumber,Double amount) {
		Account account=service.depositeAmount(accountNumber, amount);
		return account;
	}
	
	@PutMapping("/withdrwa/{accountNumber}/{amount}")
	public Account withdrwaAccount(Long accountNumber,Double amount) {
		Account account=service.withdrwaAmount(accountNumber, amount);
		return account;
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) {
		service.closeAccount(accountNumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account close");
	}
}
