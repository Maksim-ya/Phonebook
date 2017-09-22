package com.lardi.phonebook.model;


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



//    private Set<Note> noteEntities = new HashSet<>();
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
//    public Set<Note> getnoteEntities() {
//        return this.noteEntities;
//    }
//
//    public void setNoteEntities(Set<Note> noteEntities) {
//        this.noteEntities = noteEntities;
//    }
//
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
