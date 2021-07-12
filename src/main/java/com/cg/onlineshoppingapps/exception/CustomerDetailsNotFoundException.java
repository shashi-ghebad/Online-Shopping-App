package com.cg.onlineshoppingapps.exception;

@SuppressWarnings("serial")
public class CustomerDetailsNotFoundException extends RuntimeException{
	
	String msg;

	public CustomerDetailsNotFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}

