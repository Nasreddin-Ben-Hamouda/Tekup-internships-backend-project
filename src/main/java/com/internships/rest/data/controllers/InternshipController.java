package com.internships.rest.data.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internships.rest.data.dto.InternshipDTO;
import com.internships.rest.data.services.InternshipService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/internship")
@AllArgsConstructor
public class InternshipController {
	
	private InternshipService interService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllInternships (){
		return new ResponseEntity<List<InternshipDTO>>(interService.list(),HttpStatus.OK);
	}

}
