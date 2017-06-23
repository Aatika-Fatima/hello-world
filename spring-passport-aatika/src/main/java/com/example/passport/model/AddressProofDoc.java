package com.example.passport.model;

public enum AddressProofDoc {
	WATER_BILL("WATER BILL"),AADHAAR("AADHAR"),DRIVING_LICENSE("DRIVING LICENSE");
	
	private String description;

	private AddressProofDoc(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
}
