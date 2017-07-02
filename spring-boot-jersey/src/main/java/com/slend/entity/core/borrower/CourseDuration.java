package com.slend.entity.core.borrower;

public enum CourseDuration {
	ONE(1), ONE_HALF_YEAR(1.5F), TWO(2), THREE(3), FOUR(4), FIVE(5);

	private float year;

	private CourseDuration(float year) {
		this.year = year;
	}

}
