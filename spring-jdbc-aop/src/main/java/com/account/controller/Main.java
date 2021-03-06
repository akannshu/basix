package com.account.controller;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.account.dto.Account;
import com.account.service.AccountService;

public class Main {
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("bank.xml");
		AccountService accountService = ctx.getBean("asimpl",AccountService.class);
		
//		Account a1 = new Account(1,"Ankita",40000.05);
//		Account a2 = new Account(2, "Akanksha",436456.56);	
//		
//		accountService.insert(a1);
//		accountService.insert(a2);
		
//		accountService.tranfer(1, 2, 10000.00);
	//	accountService.delete(2);
		List<Account> accounts =  accountService.getAllAccounts();
		accounts.forEach(System.out::println);
		ctx.close();
	}

}
