package com.internships.rest.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
	private String city;
	private String street;
	private int code;
}
