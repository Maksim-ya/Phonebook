package com.lardi.phonebook.dao;

import com.lardi.phonebook.entities.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class NoteDaoImpl implements  NoteDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addNote(Note note) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(note);

    }

    @Override
    public void updateNote(Note note) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(note);
    }

    @Override
    public void removeNote(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Note note = (Note) session.load(Note.class, new Integer(id));

        if (note != null) {
            session.delete(note);
        }
    }

    @Override
    public Note getNoteById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Note note = (Note) session.load(Note.class, new Integer(id));
        return note;
    }

    @Override
    public List<Note> listNotes() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Note> noteList = session.createQuery("from Note").list();

        return noteList;
    }
}
