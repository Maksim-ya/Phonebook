package com.lardi.phonebook.controller;

import com.lardi.phonebook.model.Note;
import com.lardi.phonebook.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {


    @Autowired
    NoteRepository noteRepository;



    @RequestMapping(value = "/myNote", method = RequestMethod.GET)
    public String listOfNotes(Model model) {

        model.addAttribute("notes", noteRepository.findAll());
        return "myNote";
    }

//    @RequestMapping(value = "/notes", method = RequestMethod.GET)
//    public ModelAndView notes (ModelAndView modelAndView) {
//        return modelAndView
//                .addObject("note",new Note())
//                .addObject("listNotes", this.noteRepository.findAll());
//        }


    @RequestMapping (value = "/notes/add", method = RequestMethod.POST)
    public  String addNote(@ModelAttribute("note") Note note){
        if(note.getId()==0){
            this.noteRepository.save(note);
        }
        return "redirect:/notes";
    }

    @RequestMapping("edit/{id}")
    public  String editNote(@PathVariable("id") long id, Model model){
        model.addAttribute("note",this.noteRepository.findOne(id));
        //model.addAttribute("listNotes", this.noteService.listNotes());
        return "myNote";
    }

    @RequestMapping("/remove/{id}")
    public String removeNote(@PathVariable("id") long id){
        noteRepository.delete(id);
        return "redirect:/myNote";
    }

    @RequestMapping("notedata/{id}")
    public String noteData(@PathVariable("id") long id , Model model){
        model.addAttribute("notedata", noteRepository.findOne(id));
        return  "notedata";
    }

}




