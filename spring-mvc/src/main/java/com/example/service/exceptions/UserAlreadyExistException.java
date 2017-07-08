package com.example.service.exceptions;

public class UserAlreadyExistException extends RuntimeException{

	public UserAlreadyExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
