package com.lardi.phonebook.dao;


import com.lardi.phonebook.entities.Note;

import java.util.List;

public interface NoteDao {
    public void addNote (Note note);

    public void updateNote (Note note);

    public void removeNote (int id);

    public Note  getNoteById(int id);

    public List<Note> listNotes();
}
