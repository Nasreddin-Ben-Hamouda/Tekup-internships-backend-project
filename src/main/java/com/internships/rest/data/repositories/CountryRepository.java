package com.internships.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internships.rest.data.models.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
