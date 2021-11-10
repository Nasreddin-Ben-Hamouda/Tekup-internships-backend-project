package com.internships.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internships.rest.data.models.InternshipAttachement;

public interface InternshipAttachementRepository extends JpaRepository<InternshipAttachement, Long> {

}
