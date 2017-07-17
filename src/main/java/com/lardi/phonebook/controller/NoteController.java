package com.lardi.phonebook.controller;

import com.lardi.phonebook.entities.Note;
import com.lardi.phonebook.service.NoteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoteController {
    private NoteService noteService;


    @Autowired(required = true)
    public void setNoteService (NoteService noteService){
        this.noteService= noteService;
    }

    @RequestMapping(value = "notes", method = RequestMethod.GET)
    public String listNotes(Model model) {
        model.addAttribute("note", new Note());
        model.addAttribute("listNotes", this.noteService.listNotes());
        return "note";
    }
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index(Model model) {
//        model.addAttribute("phoneBalances", (List<PhoneBalance>) phoneBalanceRepository.findByCurrent(true));
//        return "index";
//    }


    @RequestMapping (value = "/notes/add", method = RequestMethod.POST)
    public  String addNote(@ModelAttribute("note") Note note){
        if(note.getId()==0){
            this.noteService.addNote(note);
        }else {
            this.noteService.updateNote(note);
        }
        return "redirect:/notes";
    }

    @RequestMapping("edit/{id}")
    public  String editNote(@PathVariable("id") int id, Model model){
        model.addAttribute("note",this.noteService.getNoteById(id));
        model.addAttribute("listNotes", this.noteService.listNotes());
        return "notes";
    }

    @RequestMapping("/remove/{id}")
    public String removeNote(@PathVariable("id") int id){
        this.noteService.removeNote(id);
        return "redirect:/notes";
    }

    @RequestMapping("notedata/{id}")
    public String noteData(@PathVariable("id") int id , Model model){
        model.addAttribute("note", this.noteService.getNoteById(id));
        return  "notedata";
    }

}




