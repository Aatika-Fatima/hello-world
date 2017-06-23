package com.example.passport.exceptions;

public class ApplicationNotFoundException extends RuntimeException{

	private int applicationId;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	 

	public ApplicationNotFoundException(int applicationId) {
		super();
		this.applicationId = applicationId;
	}

	@Override
	public String toString() {
		return "ApplicationNotFoundException [applicationId=" + applicationId + "]";
	} 
	
	
	
}
