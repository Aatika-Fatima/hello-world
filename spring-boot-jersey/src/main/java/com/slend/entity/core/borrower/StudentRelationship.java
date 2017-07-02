package com.slend.entity.core.borrower;

public enum StudentRelationship {
	FATHER("FATHER"),
	MOTHER("MOTHER"),
	
	SPOUSE("SPOUSE"),
	
	BROTHER("BROTHER"),
	SISTER("SISTER"),
	COUSIN("COUSIN"),
	
	PATERNAL_UNCLE("PATERNAL_UNCLE"),
	PATERNAL_AUNT("PATERNAL_AUNT"),
	MATERNAL_UNCLE("MATERNAL_UNCLE"),
	MATERNAL_AUNT("MATERNAL_AUNT"),
	
	GRANDFATHER("GRANDFATHER"),
	GRANDMOTHER("GRANDMOTHER");
	private String description;

	private StudentRelationship(String description) {
		this.description = description;
	} 
	
	
}
