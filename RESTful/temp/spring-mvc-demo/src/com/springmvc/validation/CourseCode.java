package com.springmvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Constraint(validatedBy= CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

		//define cxoruse code
		public String value() default "grim";
		
		//define error messaage
		public String message() default"Must start with grim";
		
		//define default groups
		public Class<?>[] groups() default {};
		
		//define payloads
		public Class<? extends Payload>[] payload() default{};
}
