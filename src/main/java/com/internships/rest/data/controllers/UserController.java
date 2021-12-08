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

import com.internships.rest.data.dto.RoleDTO;
import com.internships.rest.data.dto.UserDTO;
import com.internships.rest.data.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllUsers(){
		return new ResponseEntity<List<UserDTO>>(userService.list(),HttpStatus.OK);
	}
	@GetMapping("/roles")
	public ResponseEntity<?> getAllRoles(){
		return new ResponseEntity<List<RoleDTO>>(userService.listRoles(),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody UserDTO user){
		String result=userService.create(user);
		if(result==null)
			return new ResponseEntity<String>("User created successfully",HttpStatus.OK);
		return new ResponseEntity<String>(result,HttpStatus.BAD_REQUEST);

	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateUser(@RequestBody UserDTO user,@PathVariable Long id){
		String result=userService.update(user, id);
		if(result==null)
			return new ResponseEntity<String>("User updated successfully",HttpStatus.OK);
		return new ResponseEntity<String>(result,HttpStatus.BAD_REQUEST);

	}
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<?> deleteOffer(@PathVariable long id){
		String result=userService.delete(id);
		if(result==null)
			return new ResponseEntity<String>("User deleted successfully",HttpStatus.OK);
		return new ResponseEntity<String>(result,HttpStatus.BAD_REQUEST);
	}

}
