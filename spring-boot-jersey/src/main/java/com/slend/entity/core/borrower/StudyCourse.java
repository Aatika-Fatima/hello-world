package com.slend.entity.core.borrower;

public enum StudyCourse {
	ENGINEERING_MS("ENGINEERING_MS"),
	MBA_PGPM("MBA_PGPM"),
	MEDICAL("MEDICAL"),
	HOTEL_MANAGEMENT("HOTEL_MANAGEMENT"),
	VOCATIONAL("VOCATIONAL"),
	CERTIFICATE("CERTIFICATE"),
	OTHER("OTHER");
	private String description;

	private StudyCourse(String description) {
		this.description = description;
	}
}
