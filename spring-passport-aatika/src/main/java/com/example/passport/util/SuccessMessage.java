package com.example.passport.util;

import com.example.passport.model.ApplicationStatus;

public class SuccessMessage extends FailureMessage  {
	private int applicationId; 
	private ApplicationStatus applicationStatus;
	
	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public SuccessMessage(int status, String message, int applicationId, ApplicationStatus applicationStatus) {
		super(status, message);
		this.applicationId = applicationId;
		this.applicationStatus = applicationStatus;
	}
 
	 
 
	
}
