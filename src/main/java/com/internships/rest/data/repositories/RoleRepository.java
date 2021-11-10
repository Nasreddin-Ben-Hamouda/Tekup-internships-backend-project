package com.internships.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internships.rest.data.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
