package com.lardi.phonebook.repository;


import com.lardi.phonebook.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {

}
