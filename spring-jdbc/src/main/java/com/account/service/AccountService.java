package com.account.service;

import java.util.List;

import com.account.dto.Account;


public interface AccountService {
	
	public List<Account> getAllAccounts();

	public Account getById(Integer id);

	public void update(Account account);

	public void delete(Integer id);

	public void insert(Account account);
	
	public void tranfer(Integer senderId, Integer recieverId, Double amount );
	
	public void deposit(Integer id, Double amount);
	
	public void withdraw(Integer id, Double amount);
}
