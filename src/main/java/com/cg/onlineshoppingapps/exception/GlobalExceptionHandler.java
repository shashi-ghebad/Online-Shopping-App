package com.cg.onlineshoppingapps.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handlerExceptions(ProductNotFoundException exception, WebRequest webRequest) {

		ExceptionResponse response = new ExceptionResponse();

		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());

		ResponseEntity<Object> entity = new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<Object> handlerExceptions(AddressNotFoundException exception, WebRequest webRequest) {

		ExceptionResponse response = new ExceptionResponse();

		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());

		ResponseEntity<Object> entity = new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(CustomerDetailsNotFoundException.class)
	public ResponseEntity<Object> handlerExceptions(CustomerDetailsNotFoundException exception, WebRequest webRequest) {

		ExceptionResponse response = new ExceptionResponse();

		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());

		ResponseEntity<Object> entity = new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(OrderDetailsNotFoundException.class)
	public ResponseEntity<Object> handlerExceptions(OrderDetailsNotFoundException exception, WebRequest webRequest) {

		ExceptionResponse response = new ExceptionResponse();

		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());

		ResponseEntity<Object> entity = new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handlerExceptions(UserNotFoundException exception, WebRequest webRequest) {

		ExceptionResponse response = new ExceptionResponse();

		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());

		ResponseEntity<Object> entity = new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<Object> handlerExceptions(CategoryNotFoundException exception, WebRequest webRequest) {

		ExceptionResponse response = new ExceptionResponse();

		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());

		ResponseEntity<Object> entity = new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<Object> handlerExceptions(CartNotFoundException exception, WebRequest webRequest) {

		ExceptionResponse response = new ExceptionResponse();

		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());

		ResponseEntity<Object> entity = new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		ResponseEntity<Object> entity = new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		return entity;
	}

}
