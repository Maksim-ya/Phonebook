package com.lardi.phonebook.validator;


import com.lardi.phonebook.model.Note;
import org.springframework.stereotype.Component;
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


        if (note.getTelMobile().length() != 13) { //||!note.getTelMobile().equals("^((\\+380)([0-9]{9}))")

            errors.rejectValue("telMobile","Format.notValid","Write correct form of tel. number, please. (Example: +380661234567)");
        }
    }
}