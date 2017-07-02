/**
 * 
 */
package com.slend.entity.core.borrower;

/**
 * @author aatika.fatima
 *
 */
public enum TenureLoanYears {
	ZERO("0"), ONE("1"), TWO("2"),
	THREE("3"), FOUR("4"), FIVE("5"),
	SIX("6"), SEVEN("7"), EIGHT("8"), 
	NINE("9"), TEN("10"), TEN_PLUS("10+");

	private String description;

	private TenureLoanYears(String description) {
		this.description = description;
	}

}
