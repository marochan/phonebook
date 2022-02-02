package com.phonebook.customAnnotations.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.FIELD})
@Documented
@Constraint(validatedBy = ValidPhoneImpl.class)
public @interface ValidPhone {
    //error message if name consists of non-alphabetical signs
    String message() default "Phone must be starting with a '+' sign, followed by 11 integers!";
    //constraints
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
