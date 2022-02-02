package com.phonebook.customAnnotations.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPhoneImpl implements ConstraintValidator<ValidPhone, String> {
    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        return phone!= null && phone.length() == 12 && phone.matches("\\+[0-9]+");
    }
    @Override
    public void initialize(ValidPhone validPhone){};
}
