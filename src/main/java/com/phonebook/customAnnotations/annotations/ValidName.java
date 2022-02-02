package com.phonebook.customAnnotations.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.FIELD})
@Documented
@Constraint(validatedBy = ValidNameImpl.class)
public @interface ValidName {
    //error message if name consists of non-alphabetical signs
    String message() default "Name must consist only of alphabetical signs!";
    //constraints
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
