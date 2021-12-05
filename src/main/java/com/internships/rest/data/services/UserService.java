package com.internships.rest.data.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
	UserDetails loadUserByUsername(String email);
}
