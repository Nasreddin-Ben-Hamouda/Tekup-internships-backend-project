package com.internships.rest.data.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.internships.rest.data.models.User;
import com.internships.rest.data.repositories.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	    @Autowired
	    private UserRepository repository;

	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        User user = repository.findByEmail(email);
	        return user;
	    }
}
