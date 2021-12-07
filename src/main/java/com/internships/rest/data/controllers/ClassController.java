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

import com.internships.rest.data.dto.ClassDTO;
import com.internships.rest.data.services.ClassService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/class")
public class ClassController {
	
	private ClassService service;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createClass(@RequestBody ClassDTO classe){
		ClassDTO newClass=service.create(classe);
		if(newClass!=null) 
			return new ResponseEntity<ClassDTO>(newClass,HttpStatus.OK);
		return new ResponseEntity<String>("Class not created, try again",HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateClass(@RequestBody ClassDTO classe,@PathVariable Long id){
		ClassDTO newClass=service.update(classe, id);
		if(newClass!=null) 
			return new ResponseEntity<ClassDTO>(newClass,HttpStatus.OK);
		return new ResponseEntity<String>("Class not found, try again",HttpStatus.NOT_FOUND);

	}
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllClasses(){
		
		return new ResponseEntity<List<ClassDTO>>(service.list(),HttpStatus.OK);
	

	}
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<?> deleteClass(@PathVariable long id){
		String result=service.delete(id);
		if(result==null)
			return new ResponseEntity<String>("Class deleted successfully",HttpStatus.OK);
		return new ResponseEntity<String>(result,HttpStatus.BAD_REQUEST);
	}

}
