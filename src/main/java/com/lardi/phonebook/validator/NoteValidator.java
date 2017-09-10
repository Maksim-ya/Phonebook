package com.lardi.phonebook.validator;


import com.lardi.phonebook.model.Note;

import org.springframework.stereotype.Component;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class NoteValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Note.class.equals(aClass);
    }

    @Override
     public void validate(Object o, Errors errors) {
        Note note = (Note) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required");
        if (note.getLastName().length()<3){

            errors.rejectValue("lastName","size.message");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telMobile", "required");
        if (!note.getTelMobile().matches("^((\\+?380)([5-9]{1})([0&3-9]{1})\\d{7})$")){

            errors.rejectValue("telMobile","format.notValid");
        }





            if (!note.getEmail().equals(null)&&(!EmailValidator.getInstance().isValid(note.getEmail()))) {
                errors.rejectValue("email", "email.notValid");
            }
        }

}