package com.example.security.web.controller.util;

public class GenericRespone {
	private int status; 
	private String message;
	
	public GenericRespone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GenericRespone(int status, String message) {
		super();
		this.status = status;
		this.message = message;
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
