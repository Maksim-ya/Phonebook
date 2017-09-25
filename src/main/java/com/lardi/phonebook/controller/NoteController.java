package com.lardi.phonebook.controller;

import com.lardi.phonebook.model.Note;
import com.lardi.phonebook.model.User;
import com.lardi.phonebook.repository.NoteRepository;
import com.lardi.phonebook.validator.NoteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class NoteController {


    @Autowired
    NoteRepository noteRepository;

    @Autowired
    NoteValidator noteValidator;


    @RequestMapping(value = "/myNote", method = RequestMethod.GET)
    public String listOfNotes(Model model) {
        model.addAttribute("note", new Note());
        model.addAttribute("notes", noteRepository.findAll());
        return "myNote";
    }

    @RequestMapping(value = "/myNote/add", method = RequestMethod.POST)
    public String addNote(@ModelAttribute("note") User user, Note note, Model model, BindingResult bindingResult) {
        noteValidator.validate(note, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("notes", noteRepository.findAll());
            return "/myNote";
        }
        noteRepository.save(note);
        //noteRepository.save(note).setUser(user);



        return "redirect:/myNote";
    }

    @RequestMapping("/remove/{id}")
    public String removeNote(@PathVariable("id") long id) {
        noteRepository.delete(id);
        return "redirect:/myNote";
    }

    @RequestMapping("edit/{id}")
    public String editNote(@PathVariable("id") long id, Model model) {
        model.addAttribute("note", this.noteRepository.findOne(id));
        model.addAttribute("notes", this.noteRepository.findAll());

        return "notedata";
    }


    @RequestMapping("notedata/{id}")
    public String noteData(@PathVariable("id") long id, Model model) {
        model.addAttribute("notedata", noteRepository.findOne(id));
        return "notedata";
    }

}




