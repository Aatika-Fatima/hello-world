package com.slend.entity.core.borrower;

public enum CourseLevel {
	BACHELORS("BACHELORS DEGREE"),
	MASTERS("MASTERS DEGREE"),
	DOCTORAL("DOCTORAL DEGREE");
	private String description;

	private CourseLevel(String description) {
		this.description = description;
	}
}
