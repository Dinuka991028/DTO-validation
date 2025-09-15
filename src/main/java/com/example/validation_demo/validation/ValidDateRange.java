package com.example.validation_demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateRangeValidator.class)
public @interface ValidDateRange {
    String message() default "Invalid date range";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
