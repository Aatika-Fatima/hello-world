package com.slend.entity.core.borrower;

public enum EmploymentType {
	SALARIED("SALARIED"),NON_SALARIED("NON_SALARIED"),
	SALARIED_GOVT_EMPLOYEE("SALARIED_GOVT_EMPLOYEE"),
	SALARIED_NON_GOVT_EMPLOYEE("SALARIED_NON_GOVT_EMPLOYEE")
	,SELF_EMPLOYED_PROFESSIONAL("SELF_EMPLOYED_PROFESSIONAL"),
	SELF_EMPLOYED_NON_PROFESSIONAL("SELF_EMPLOYED_NON_PROFESSIONAL"),
	HOME_MAKER("HOME_MAKER");
	
	private String description;

	private EmploymentType(String description) {
		this.description = description;
	} 
	

}
