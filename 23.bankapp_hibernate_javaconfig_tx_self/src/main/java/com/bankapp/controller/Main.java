package com.bankapp.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.entities.Account;
import com.bankapp.service.account.AccountService;

public class Main {

	public static void main(String[] args){
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bank.xml");
	AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		
		AccountService accountService=applicationContext.getBean("as", AccountService.class);
		accountService.transfer(1, 2, 100);
		/*
		 * Account account=new Account("indu", 2000, "delhi", "450045545",
		 * "indu@gmail.com");
		 */
		/*
		 * Account account=new Account("rajesh kumar", 2000, "delhi",
		 * "450045545","rk@gmail.com"); accountService.insert(account);
		 * System.out.println("---------");
		 */
		/*
		 * List<Account> accounts=accountService.getAllAccounts(); accounts.forEach(a->
		 * System.out.println(a));
		 */

		/*
		 * List<Account> accounts=accountService.getAllAccounts(); accounts.forEach(a->
		 * System.out.println(a));
		 */
	
	
		//List<Account> accounts=accountService.getAllAccounts();
		//accounts.forEach(a-> System.out.println(a));

		
//		 Account account=accountService.getById(3);
//		 System.out.println(account);
//		 

		
//
//		accountService.insert(account);
//		 System.out.println("---------");

//		 accountService.delete(13);
//		 System.out.println("---------");

		// (int id, String address, String phone, String email)
//		accountService.updateCustomerDetails(11, "bang", "54545545", "leena1@gmail.com");
//		System.out.println("%%%%%%%%%%%%%%%%");

//		Account account=new Account("sunita", 2000, "delhi", "450045545", "sunita@gmail.com");
//		//Account account2=new Account("suman", 2000, "delhi", "454545545", "suman@gmail.com");
//		
//		accountService.insert(account);
		// accountService.insert(account);


//		
//		System.out.println(accountService.getById(1));
//		System.out.println(accountService.getById(2));

	}
}
