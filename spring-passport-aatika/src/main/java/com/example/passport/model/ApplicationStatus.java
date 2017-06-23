package com.example.passport.model;

public enum ApplicationStatus {
	PENDING("PENDING"), DRAFT("DRAFT"), COMPLETED("COMPLETED"); 
	private String description;
	
	private ApplicationStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
}
