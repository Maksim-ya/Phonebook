package com.lardi.phonebook.controller;

import com.lardi.phonebook.model.Note;
import com.lardi.phonebook.repository.NoteRepository;
import com.lardi.phonebook.validator.NoteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;


@Controller
public class NoteController {


    @Autowired
    NoteRepository noteRepository;

    @Autowired
    NoteValidator noteValidator;


    @RequestMapping(value = "/myNote", method = RequestMethod.GET)
    public String listOfNotes(Model model) {
        model.addAttribute("note",new Note());
//        if (userRepository.equals(note.getLogin())){
        model.addAttribute("notes", noteRepository.findAll());
        return "myNote";
    }

    @RequestMapping (value = "/myNote/add",method = RequestMethod.POST)
    public  String addNote( @ModelAttribute ("note")  Note note,Model model, BindingResult bindingResult){
        noteValidator.validate(note,bindingResult);

        if(bindingResult.hasErrors()){
            model.addAttribute("notes", noteRepository.findAll());
            return "/myNote";
        }

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
//            UserDetails userDetail = (UserDetails) auth.getPrincipal();
//
//            if (userDetail != null) {
//                model.addAttribute("note_user_id", userDetail.getUsername());
//            } else {
//                model.addAttribute("note_user_id", "ololo");
//            }
//        }

       noteRepository.save(note);

        return "redirect:/myNote";
    }

    @RequestMapping("/remove/{id}")
    public String removeNote(@PathVariable("id") long id){
        noteRepository.delete(id);
        return "redirect:/myNote";
    }

    @RequestMapping("edit/{id}")
    public  String editNote(@PathVariable("id") long id, Model model){
        model.addAttribute("note",this.noteRepository.findOne(id));
        model.addAttribute("notes", this.noteRepository.findAll());

        return "notedata";
    }


    @RequestMapping("notedata/{id}")
    public String noteData(@PathVariable("id") long id , Model model){
        model.addAttribute("notedata", noteRepository.findOne(id));
        return  "notedata";
    }

}




