package com.example.BankManagementApp.service;

import java.util.List;

import com.example.BankManagementApp.entity.Account;

public interface AccountService {

	public Account createAccount(Account account);
	public Account getAccountDetailsByAccountNumber(Long accountNumber);
	public List<Account> getAllAccountDetails();
	public Account depositeAmount(Long accountNumber, Double Amount);
	public Account withdrwaAmount(Long accountNumber,Double amount);
	public void closeAccount(Long accountNumber);
}
