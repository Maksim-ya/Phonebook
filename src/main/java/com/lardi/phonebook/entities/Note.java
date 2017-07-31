package com.lardi.phonebook.entities;


import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "middleName",nullable = false)
    private String middleName;

    @Column(name = "telMobile",nullable = false)
    private String telMobile;

    @Column(name = "telDomastic")
    private String telDomastic;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    public String getTelDomastic() {
        return telDomastic;
    }

    public void setTelDomastic(String telDomastic) {
        this.telDomastic = telDomastic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", telMobile='" + telMobile + '\'' +
                ", telDomastic='" + telDomastic + '\'' +
                ", address=" + address +
                ", email=" + email +
                '}';
    }
}