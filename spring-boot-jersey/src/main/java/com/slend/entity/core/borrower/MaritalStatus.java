package com.slend.entity.core.borrower;

public enum MaritalStatus {
	MARRIED("MARRIED"),UNMARRIED("UNMARRIED");
	private String description;

	private MaritalStatus(String description) {
		this.description = description;
	}
}
