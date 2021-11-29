package com.internships.rest.data.dto;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
	
	private String authToken;
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String role;

	
}
