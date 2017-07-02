package com.slend.entity.core.borrower;

public enum AboutProperty {
	PURCHASE("Purchase or construct on identified property"),
	REPAIR("Repair/Renovation of own house/flat"),
	BALANCE_TRANSFER("Balance Transfer(Take over)"), 
	UNIDENTIFIED("Loan for unidentified Property (Pre approved loan)");
	private String description;

	private AboutProperty(String description) {
		this.description = description;
	}
	

}
