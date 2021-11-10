package com.internships.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internships.rest.data.models.Internship;

public interface InternshipRepository extends JpaRepository<Internship, Long> {

}
