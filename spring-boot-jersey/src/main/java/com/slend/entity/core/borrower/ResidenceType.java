package com.slend.entity.core.borrower;

public enum ResidenceType {
	HOUSE("HOUSE"), APARTMENT("APARTMENT"); 
	
	private String description;

	private ResidenceType(String description) {
		this.description = description;
	} 
}
