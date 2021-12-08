package com.internships.rest.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatisticsStudentResponse {
	
	private Long requestedInternships;
	private Long confirmedInternships;
	private int createdOffers;
	private Long internships2017;
	private Long internships2018;
	private Long internships2019;
	private Long internships2020;
	private Long internships2021;
	
}
