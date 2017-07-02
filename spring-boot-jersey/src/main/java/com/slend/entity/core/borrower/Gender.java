package com.slend.entity.core.borrower;

public enum Gender {
	MALE("MALE"), FEMALE("FEMALE"); 
	private String description;

	private Gender(String description) {
		this.setDescription(description);
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	} 
	
}
