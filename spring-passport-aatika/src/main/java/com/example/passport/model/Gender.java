package com.example.passport.model;

public enum Gender {
	MALE("MALE"), FEMALE("FEMALE");

	private String description;

	private Gender(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
