package com.internships.rest.data.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internships.rest.data.dto.JwtResponse;
import com.internships.rest.data.dto.UserDTO;
import com.internships.rest.data.models.User;
import com.internships.rest.data.util.JwtUtil;

import lombok.AllArgsConstructor;

//@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
	private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    private ModelMapper mapper;
   
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserDTO user) throws Exception {
    	
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
       
        return new ResponseEntity<JwtResponse>(new JwtResponse(jwt,mapper.map(userDetails, UserDTO.class)),HttpStatus.OK);
     
    }

    @GetMapping("/whoami")
    public UserDTO getAuthenticatedUser() throws Exception {
  
        User userDetails=(User)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return mapper.map(userDetails, UserDTO.class);
    }
  

}
