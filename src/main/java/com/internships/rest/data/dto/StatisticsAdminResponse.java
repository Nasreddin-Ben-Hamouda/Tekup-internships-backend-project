package com.internships.rest.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatisticsAdminResponse {
	
	private Long adminsNumber;
	private Long teachersNumber;
	private Long studentsNumber;
	private Long internshipsNumber;
	private Long defensesNumber;
	private Long internships2017;
	private Long internships2018;
	private Long internships2019;
	private Long internships2020;
	private Long internships2021;
	private Long defenses2017;
	private Long defenses2018;
	private Long defenses2019;
	private Long defenses2020;
	private Long defenses2021;

}
