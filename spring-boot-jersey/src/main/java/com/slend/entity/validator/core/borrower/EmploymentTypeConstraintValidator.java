package com.slend.entity.validator.core.borrower;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.slend.entity.core.borrower.EmploymentType;

@Component
public class EmploymentTypeConstraintValidator implements ConstraintValidator<CheckEmploymentType, EmploymentType> {

	@Override
	public void initialize(CheckEmploymentType arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(EmploymentType employmentType, ConstraintValidatorContext validator) {
		System.out.println("*********************");
		System.out.println(employmentType.toString());
		System.out.println(employmentType);
		System.out.println("*********************");
		if (employmentType.toString().equals(EmploymentType.SALARIED.toString())
				|| employmentType.toString().equals(EmploymentType.NON_SALARIED.toString()))
			return true;
		return false;

		/*
		 * if (employmentType.toString() == (EmploymentType.SALARIED) ||
		 * employmentType == (EmploymentType.NON_SALARIED)) { return true; }
		 */
	}

}
