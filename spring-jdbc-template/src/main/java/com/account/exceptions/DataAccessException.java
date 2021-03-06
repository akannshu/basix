package com.account.exceptions;

public class DataAccessException extends RuntimeException {
	
	private static final long serialVersionUID = 7825016138280469727L;

	public DataAccessException(String message) {
		super();
		System.out.println(message);
	}
	
	

}
