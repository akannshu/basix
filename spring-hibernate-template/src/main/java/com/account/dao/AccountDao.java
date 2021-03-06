package com.account.dao;

import java.util.List;

import com.account.dto.Account;

public interface AccountDao {
	
    public List<Account> getAllAccounts();
    public Account getById(Integer id);
    public void update(Account account);
    public void delete(Integer id);
    public void insert(Account account);

}
