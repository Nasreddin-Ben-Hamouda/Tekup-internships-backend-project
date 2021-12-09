package com.internships.rest.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyFramerDTO {
	
	private String name;
	private String function;
	private int phone;
	private String email;

}
