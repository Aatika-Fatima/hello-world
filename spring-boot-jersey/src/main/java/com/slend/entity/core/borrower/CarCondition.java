package com.slend.entity.core.borrower;

public enum CarCondition {
	NEW_CAR("NEW_CAR"), OLD_CAR("OLD_CAR");
	private String description;

	private CarCondition(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
	
}
