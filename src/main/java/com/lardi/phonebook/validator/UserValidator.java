package com.lardi.phonebook.validator;

import com.lardi.phonebook.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user= (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "required");
        if (user.getLogin().length() < 3) {

            errors.rejectValue("login", "size.message");
        }
    }
}
