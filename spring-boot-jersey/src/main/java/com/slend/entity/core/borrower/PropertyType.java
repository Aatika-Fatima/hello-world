package com.slend.entity.core.borrower;

public enum PropertyType {
	READY("Purchase of ready-built property"),
	UNDER_CONSTRUCTION("Purchase of under-construction property"),
	PLOT_PURCHASE("Purchase of plot"),
	CONSTRUCTION_OWNED("Construction on residential plot owned by you"),
	EXTENSION("Extension of own flat/house");
	private String description;

	private PropertyType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
	
	
}
