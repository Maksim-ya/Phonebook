package com.lardi.phonebook.repository;


import com.lardi.phonebook.model.Note;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface NoteRepository extends CrudRepository<Note, Long> {

//    @Transactional
//    @Modifying
//    @Query("update Note n set n.address = 7 where n.id = :id")
//     int update(@Param("id") long id);
}
