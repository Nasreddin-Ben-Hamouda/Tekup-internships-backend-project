package com.internships.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.internships.rest.data.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
