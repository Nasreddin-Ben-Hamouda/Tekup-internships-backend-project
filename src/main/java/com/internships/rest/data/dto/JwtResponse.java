package com.internships.rest.data.dto;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
	
	private String authToken;
	private UserDTO user;

	
}
