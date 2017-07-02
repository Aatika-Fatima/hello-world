package com.slend.entity.core.borrower;

public enum LoanStatus {
	YES("YES"), NO("NO");
	private String description;

	private LoanStatus(String description) {
		this.description = description;
	} 
}
