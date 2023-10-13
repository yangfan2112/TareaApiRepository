package edu.cesur.fullstack.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployeeCodeValidator.class)

public @interface ValidEmployeeCode {

	String message() default "Código inválido. Debe contener exactamente EMP, 3 letras minúscula de tu departamento y  4 números.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "PREFIX-";
}
