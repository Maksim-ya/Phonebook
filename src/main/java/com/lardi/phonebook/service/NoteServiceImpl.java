package com.lardi.phonebook.service;

import com.lardi.phonebook.dao.NoteDao;
import com.lardi.phonebook.entities.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteDao noteDao;

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }



    @Override
    @Transactional
    public void addNote(Note note) {
        this.noteDao.addNote(note);
    }

    @Override
    @Transactional
    public void updateNote(Note note) {
        this.noteDao.updateNote(note);

    }

    @Override
    @Transactional
    public void removeNote(int id) {
        this.noteDao.removeNote(id);

    }

    @Override
    @Transactional
    public Note getNoteById(int id) {
        return this.noteDao.getNoteById(id);
    }

    @Override
    @Transactional
    public List<Note> listNotes() {
        return this.noteDao.listNotes() ;
    }
}
