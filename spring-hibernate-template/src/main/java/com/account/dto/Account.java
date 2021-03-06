package com.account.dto;

public class Account {
	
	private Integer id;
	private String name;
	private Double balance;
	
	public Account() {}

	public Account(Integer id, String name, Double balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public Account(String name, Double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
		}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", balance=");
		builder.append(balance);
		builder.append("]");
		return builder.toString();
	}
	
		
}
