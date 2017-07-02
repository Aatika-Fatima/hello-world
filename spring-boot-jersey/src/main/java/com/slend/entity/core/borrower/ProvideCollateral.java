package com.slend.entity.core.borrower;

public enum ProvideCollateral {
	YES("YES"), NO("NO"); 
	private String description;

	private ProvideCollateral(String description) {
		this.description = description;
	} 
	
}
