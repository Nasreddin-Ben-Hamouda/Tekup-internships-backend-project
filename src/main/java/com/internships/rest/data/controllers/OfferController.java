package com.internships.rest.data.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internships.rest.data.dto.OfferDTO;
import com.internships.rest.data.services.OfferService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/offer")
public class OfferController {
	private OfferService offerService;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createOffer(@ModelAttribute OfferDTO offer){
		OfferDTO newOffer=offerService.create(offer);
		if(newOffer!=null) 
			return new ResponseEntity<OfferDTO>(newOffer,HttpStatus.OK);
		return new ResponseEntity<String>("Offer not created, try again",HttpStatus.BAD_REQUEST);

	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateOffer(@ModelAttribute OfferDTO offer,@PathVariable Long id){
		OfferDTO newOffer=offerService.update(offer, id);
		if(newOffer!=null) 
			return new ResponseEntity<OfferDTO>(newOffer,HttpStatus.OK);
		return new ResponseEntity<String>("Offer not updated, try again",HttpStatus.BAD_REQUEST);

	}
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllOffers(){
		
		return new ResponseEntity<List<OfferDTO>>(offerService.list(),HttpStatus.OK);
	

	}
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<?> deleteOffer(@PathVariable long id){
		if(offerService.delete(id))
			return new ResponseEntity<String>("Offer deleted successfully",HttpStatus.OK);
		return new ResponseEntity<String>("Offer Not Found",HttpStatus.NOT_FOUND);
	}

}
