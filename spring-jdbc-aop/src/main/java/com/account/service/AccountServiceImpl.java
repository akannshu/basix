package com.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.aspects.Loggable;
import com.account.dao.AccountDao;
import com.account.dto.Account;

@Service(value = "asimpl")
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	public AccountServiceImpl() {}
	
	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	@Loggable
	public List<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
	}

	@Override
	@Loggable
	public Account getById(Integer id) {
		return accountDao.getById(id);
	}

	@Override
	@Loggable
	public void update(Account account) {
		accountDao.update(account);
	}

	@Override
	@Loggable
	public void delete(Integer id) {
		accountDao.delete(id);
	}

	@Override
	@Loggable
	public void insert(Account account) {
		accountDao.insert(account);
	}

	@Override
	@Loggable
	public void tranfer(Integer senderId, Integer recieverId, Double amount) {
		withdraw(senderId, amount);
		deposit(recieverId, amount);
		System.out.println("Amount is transfered");
	}

	@Override
	@Loggable
	public void deposit(Integer id, Double amount) {
		Account account = getById(id);
		account.setBalance(account.getBalance()+amount);
		update(account);
	}

	@Override
	@Loggable
	public void withdraw(Integer id, Double amount) {
		Account account = getById(id);
		account.setBalance(account.getBalance()-amount);
		update(account);
	}

}
