package com.internships.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internships.rest.data.models.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {

}
