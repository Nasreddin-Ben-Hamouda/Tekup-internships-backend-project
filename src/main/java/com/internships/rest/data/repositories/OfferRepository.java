package com.internships.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internships.rest.data.models.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long>{

}
