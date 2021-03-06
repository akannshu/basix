package com.account.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.account.dto.Account;
import com.account.service.AccountService;

public class Main {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("bank.xml");
	AccountService accountService = ctx.getBean("asimpl",AccountService.class);
	
//	Account a1 = new Account(1,"Ankita",40000.05);
//	Account a2 = new Account(2, "Akanksha",436456.56);	
//	

}
