package com.lardi.phonebook.model;


import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String login;
    // @Length(min = 5, message = "*Your password must have at least 5 characters")
    @Column(name = "password")
   // @Transient
    private String password;

    @Column(name = "allname")
    private String allname;




    @OneToMany( mappedBy = "user")
    private Set<Note> notes = new HashSet<>();

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

//    public void addNoteEntities(Note note) {
//        note.setUser(this);
//        this.noteEntities.add(note);
//    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAllname() {
        return allname;
    }

    public void setAllname(String allname) {
        this.allname = allname;
    }
}
