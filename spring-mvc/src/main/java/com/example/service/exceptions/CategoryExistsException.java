package com.example.service.exceptions;

public class CategoryExistsException extends RuntimeException{

	public CategoryExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CategoryExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CategoryExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CategoryExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
