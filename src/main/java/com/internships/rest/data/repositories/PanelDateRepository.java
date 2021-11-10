package com.internships.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internships.rest.data.models.PanelDate;

public interface PanelDateRepository extends JpaRepository<PanelDate, Long> {

}
