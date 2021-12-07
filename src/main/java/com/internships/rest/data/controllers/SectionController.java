package com.internships.rest.data.controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internships.rest.data.dto.SectionDTO;
import com.internships.rest.data.services.SectionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/section")
public class SectionController {
	
	private SectionService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> createSection(@RequestBody SectionDTO section){
		SectionDTO newSection=service.create(section);
		if(newSection!=null) 
			return new ResponseEntity<SectionDTO>(newSection,HttpStatus.OK);
		return new ResponseEntity<String>("Section not created, try again",HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateSection(@RequestBody SectionDTO section,@PathVariable Long id){
		SectionDTO newSection=service.update(section, id);
		if(newSection!=null) 
			return new ResponseEntity<SectionDTO>(newSection,HttpStatus.OK);
		return new ResponseEntity<String>("Section not found, try again",HttpStatus.NOT_FOUND);

	}
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllSections(){
		
		return new ResponseEntity<List<SectionDTO>>(service.list(),HttpStatus.OK);
	

	}
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<?> deleteSection(@PathVariable long id){
		String result=service.delete(id);
		if(result==null)
			return new ResponseEntity<String>("Section deleted successfully",HttpStatus.OK);
		return new ResponseEntity<String>(result,HttpStatus.BAD_REQUEST);
	}

}
