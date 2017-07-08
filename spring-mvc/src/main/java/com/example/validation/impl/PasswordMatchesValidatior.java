package com.example.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.validation.PasswordMatches;
import com.example.web.dto.UserDto;

public class PasswordMatchesValidatior implements ConstraintValidator<PasswordMatches, UserDto> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
		if (userDto.getPassword().equals(userDto.getReEnterPassword()))
			return true;
		return false;
	}

}
