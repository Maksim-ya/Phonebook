package com.lardi.phonebook.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SecurityServiceImpl implements SecurityService{

//    @Autowired
//    private UserDetailsService userDetailsService;

//    @Autowired
//   private UserDetailsImpl userDetailsImpl;


    @Override
    public String findLoggedInUserId() {
        Object userDetails =  SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails) userDetails).getUsername();
        }

        return "ololo";
    }
}
