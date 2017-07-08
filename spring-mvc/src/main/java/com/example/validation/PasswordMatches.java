package com.example.validation;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import com.example.validation.impl.PasswordMatchesValidatior;
@Target({TYPE,FIELD,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy=PasswordMatchesValidatior.class)
public @interface PasswordMatches {
	String message() default "Password doesnot matches";

}
