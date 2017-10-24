package com.lardi.phonebook.repository;


import com.lardi.phonebook.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {

    User findByLogin(String login);
}
