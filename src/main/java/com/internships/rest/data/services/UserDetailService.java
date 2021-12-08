package com.internships.rest.data.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailService {
	UserDetails loadUserByUsername(String email);
}
