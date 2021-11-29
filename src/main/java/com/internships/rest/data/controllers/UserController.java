package com.internships.rest.data.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internships.rest.data.dto.JwtResponse;
import com.internships.rest.data.models.User;
import com.internships.rest.data.util.JwtUtil;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class UserController {
	private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
   
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody User user) throws Exception {
    	
    	Authentication auth;
    	try {
                    auth=authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
        } catch (Exception ex) {
            return new ResponseEntity<String>("Invalid username/password",HttpStatus.NOT_FOUND);
        }
    	String jwt = jwtUtil.generateToken(user.getEmail());
        User userDetails=(User) auth.getPrincipal();
        return new ResponseEntity<JwtResponse>(new JwtResponse(jwt,userDetails.getId(),userDetails.getFirstName()
        		,userDetails.getLastName(),userDetails.getEmail(),userDetails.getRole().getTitle()),HttpStatus.OK);
     
    }
  

}
