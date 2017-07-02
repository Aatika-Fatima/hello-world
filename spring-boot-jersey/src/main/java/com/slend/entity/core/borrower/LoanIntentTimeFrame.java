package com.slend.entity.core.borrower;

public enum LoanIntentTimeFrame {
	ONE("1"),THREE("3"),SIX("6"),IMMEDIATE("IMMEDIATE");
	private String description;

	private LoanIntentTimeFrame(String description) {
		this.description = description;
	} 
}
