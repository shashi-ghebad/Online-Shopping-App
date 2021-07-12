package com.cg.onlineshoppingapps.exception;

@SuppressWarnings("serial")
public class OrderDetailsNotFoundException extends RuntimeException {
	
	String msg;

	public OrderDetailsNotFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
