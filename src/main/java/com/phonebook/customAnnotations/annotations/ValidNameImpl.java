package com.phonebook.customAnnotations.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNameImpl implements ConstraintValidator<ValidName, String> {
    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return name != null && name.matches("[a-zA-Z]+");
    }
    @Override
    public void initialize(ValidName validName){};
}
