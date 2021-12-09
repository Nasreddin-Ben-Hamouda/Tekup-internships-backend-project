package com.internships.rest.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyDTO {
	
	private String name;
	private String domain;
	private String address;
	private String website;

}
