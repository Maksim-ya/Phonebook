package com.lardi.phonebook.service;


import com.lardi.phonebook.model.User;

public interface SecurityService {
    String findLoggedInUserId();
    User findUserByLogin(String login);
}
