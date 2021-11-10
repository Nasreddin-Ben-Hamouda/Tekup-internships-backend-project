package com.internships.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internships.rest.data.models.DefenseDecision;

public interface DefenseDecisionRepository extends JpaRepository<DefenseDecision, Long> {

}
