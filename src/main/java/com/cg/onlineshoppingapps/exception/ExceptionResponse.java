package com.cg.onlineshoppingapps.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {

	private String message;
	@SuppressWarnings("unused")
	private LocalDateTime dateTime;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;

	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;

	}

}
