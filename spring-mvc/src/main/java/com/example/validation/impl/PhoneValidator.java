package com.example.validation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.validation.ValidPhone;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

	Pattern pattern; 
	Matcher matcher;
	
	private final String PHONE_PATTERN = "\\d{3}-\\d{3}-\\d{4}";
	@Override
	public void initialize(ValidPhone constraintAnnotation) {
 		
	}

	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		pattern = Pattern.compile(PHONE_PATTERN);
		matcher = pattern.matcher(phoneNumber);
		if(matcher.matches())
			return true;
		return false;
	}

}
