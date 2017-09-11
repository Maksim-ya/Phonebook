package com.lardi.phonebook.repository;


import com.lardi.phonebook.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {


}
