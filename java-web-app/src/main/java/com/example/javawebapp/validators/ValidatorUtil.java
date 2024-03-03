package com.example.javawebapp.validators;

import java.util.Set;

import com.example.javawebapp.forms.CadastroForm;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidatorUtil {
    public static <T> Set<ConstraintViolation<T>> validateObject(T object) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(object);
    }

    public static ConstraintViolation<CadastroForm> createViolation(String string) {
        return null;
    }
}
