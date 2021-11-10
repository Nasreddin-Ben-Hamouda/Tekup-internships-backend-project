package com.internships.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internships.rest.data.models.Class;

public interface ClassRepository extends JpaRepository<Class, Long> {

}
