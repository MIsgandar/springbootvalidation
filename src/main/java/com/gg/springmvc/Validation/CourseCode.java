package com.gg.springmvc.Validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintsValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) //How long the marked annotaion is used.Process it in runtime
public @interface CourseCode {

    // Define default course code
    public String value() default "GG";

    // Define default error message
    public String message() default "must start with GG";

    // Define default groups
    public Class<?>[] groups() default {};

    // Define default payloads (provide custom details about validatipn failure such as severity level,error code etc.)
    public Class<? extends Payload>[] payLoad() default {};
}
