package com.example.passport.util;

public class FailureMessage {
	private int status; 
	private String message;
	public FailureMessage(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public FailureMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	} 
	
	
}
