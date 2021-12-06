package com.internships.rest.data.services;

import java.util.List;

import com.internships.rest.data.dto.OfferDTO;
import com.internships.rest.data.models.Offer;

public interface OfferService {
	
	Offer findById(Long id);
	OfferDTO create(OfferDTO offer);
	OfferDTO update(OfferDTO offer,Long id);
	Boolean delete(Long id);
	List<OfferDTO> list ();
}
