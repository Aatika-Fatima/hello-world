package com.slend.entity.validator.core.borrower;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.slend.entity.core.borrower.EmploymentType;

@Component
public class EmploymentTypeConstraintValidator implements ConstraintValidator<ValidEmploymentType, EmploymentType> {

	@Override
	public void initialize(ValidEmploymentType arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(EmploymentType employmentType, ConstraintValidatorContext validator) {
		System.out.println(EmploymentType.values());
		if (employmentType == (EmploymentType.SALARIED) || employmentType == (EmploymentType.NON_SALARIED)) {
			return true;
		}
		return false;
	}

}
