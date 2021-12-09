package com.internships.rest.data.controllers;

import java.util.stream.Collectors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internships.rest.data.dto.StatisticsAdminResponse;
import com.internships.rest.data.dto.StatisticsStudentResponse;
import com.internships.rest.data.dto.StatisticssTeacherResponse;
import com.internships.rest.data.models.User;
import com.internships.rest.data.repositories.DefenseRepository;
import com.internships.rest.data.repositories.InternshipRepository;
import com.internships.rest.data.repositories.UserRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController {
	private UserRepository userRepo;
	private InternshipRepository interRepo;
	private DefenseRepository defenseRepo;
	@GetMapping("/admin")
	public ResponseEntity<?> getStatisticsForAdmin(){
		Long adminsNumber=(long)2;
		Long teachersNumber=(long)3;
		Long studentsNumber=(long)6;
		Long internshipsNumber=(long)3;
		Long defensesNumber=(long)1;
		Long internships2017=(long)0;
		Long internships2018=(long)1;
		Long internships2019=(long)2;
		Long internships2020=(long)2;
		Long internships2021=(long)2;
		Long defenses2017=(long)0;
		Long defenses2018=(long)1;
		Long defenses2019=(long)2;
		Long defenses2020=(long)1;
		Long defenses2021=(long)3;
		StatisticsAdminResponse response=new StatisticsAdminResponse(adminsNumber, teachersNumber, studentsNumber, internshipsNumber, defensesNumber, internships2017, internships2018, internships2019, internships2020, internships2021, defenses2017, defenses2018, defenses2019, defenses2020, defenses2021);

		return new ResponseEntity<StatisticsAdminResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/teacher")
	public ResponseEntity<?> getStatisticsForTeacher(){
		User userDetails=(User)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		int framedInternships=4;
		int reportedDefenses=2;
		int chairedDefenses=3;
		int panelsNumber=2;
		int createdOffers=2;
		Long internships2017=(long)2;
		Long internships2018=(long)3;
		Long internships2019=(long)4;
		Long internships2020=(long)2;
		Long internships2021=(long)3;
		StatisticssTeacherResponse response=new StatisticssTeacherResponse(framedInternships, reportedDefenses, chairedDefenses, panelsNumber, createdOffers, internships2017, internships2018, internships2019, internships2020, internships2021);
		
		return new ResponseEntity<StatisticssTeacherResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/student")
	public ResponseEntity<?> getStatisticsForStudent(){
		User userDetails=(User)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		int createdOffers=userDetails.getCreatedOffers().size();
		Long requestedInternships=(long)1;
		Long confirmedInternships=(long)2;
		
		Long internships2017=(long)0;
		Long internships2018=(long)0;
		Long internships2019=(long)1;
		Long internships2020=(long)1;
		Long internships2021=(long)1;
		StatisticsStudentResponse response=new StatisticsStudentResponse(requestedInternships, confirmedInternships, createdOffers, internships2017, internships2018, internships2019, internships2020, internships2021);
		return new ResponseEntity<StatisticsStudentResponse>(response,HttpStatus.OK);
	}

}
