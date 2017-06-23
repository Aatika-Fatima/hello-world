package com.example.passport.model;

public enum PhotoProofDoc {
	AADHAAR("AADHAR"), PAN("PAN"), DRIVING_LICENSE("DRIVING LICENSE");

	private String description;

	private PhotoProofDoc(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
