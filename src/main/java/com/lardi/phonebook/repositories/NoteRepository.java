package com.lardi.phonebook.repositories;

import com.lardi.phonebook.entities.Note;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note,Long> {
    @Transactional
    @Modifying
    //@Query()
    public void saveNote(Note note);

    public void saveAndUpdateNote(Note note);

    public void deleteNote(long id);

    public Note  findById(long id);

    public List<Note> findAllNotes();
}
