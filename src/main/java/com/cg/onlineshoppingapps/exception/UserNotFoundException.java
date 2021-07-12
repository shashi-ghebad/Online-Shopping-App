package com.cg.onlineshoppingapps.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
	
	String msg;

	public UserNotFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
