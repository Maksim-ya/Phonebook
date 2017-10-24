package com.lardi.phonebook.service;


import com.lardi.phonebook.model.User;
import com.lardi.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class SecurityServiceImpl implements SecurityService {


    @Autowired
    UserRepository userRepository;


    @Override
    public String findLoggedInUserLogin() {
        Object userDetails = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails) userDetails).getUsername();
        }

        return "ololo";
    }


    @Override
    public User findUserByLogin(String login) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByLogin(login));
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException("Username '" + "' not found");
        }

    }
}
