package com.slend.entity.core.borrower;

public enum LoanReason {
	MARRIAGE("MARRIAGE"), 
	MEDICAL("MEDICAL"),
	EDUCATION("EDUCATION"), 
	OTHER("OTHER");
	private String description;

	private LoanReason(String description) {
		this.description = description;
	}
	
}
