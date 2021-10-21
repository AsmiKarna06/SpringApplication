package customannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


import validators.YearConstraintValidator;

@Constraint(validatedBy=YearConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Year {
	int value();  		//exposes the value of the Year
	String message() default "Invalid year Year should be 2001";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
