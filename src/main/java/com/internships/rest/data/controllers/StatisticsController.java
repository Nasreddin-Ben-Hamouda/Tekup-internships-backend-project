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
		Long adminsNumber=userRepo.findAll()
								  .stream()
								  .filter(user->user.getRole().getTitle().equals("ADMIN"))
								  .collect(Collectors.counting());
		Long teachersNumber=userRepo.findAll()
				  .stream()
				  .filter(user->user.getRole().getTitle().equals("TEACHER"))
				  .collect(Collectors.counting());
		Long studentsNumber=userRepo.findAll()
				  .stream()
				  .filter(user->user.getRole().getTitle().equals("STUDENT"))
				  .collect(Collectors.counting());
		Long internshipsNumber=interRepo.findAll()
										.stream()
										.collect(Collectors.counting());
		Long defensesNumber=defenseRepo.findAll()
									   .stream()
									   .collect(Collectors.counting());	
		Long internships2017=interRepo.findAll()
									  .stream()
									  .filter(inter->inter.getCreatedAt().getYear()==2017)
									  .collect(Collectors.counting());
		Long internships2018=interRepo.findAll()
				  .stream()
				  .filter(inter->inter.getCreatedAt().getYear()==2018)
				  .collect(Collectors.counting());
		Long internships2019=interRepo.findAll()
				  .stream()
				  .filter(inter->inter.getCreatedAt().getYear()==2019)
				  .collect(Collectors.counting());
		Long internships2020=interRepo.findAll()
				  .stream()
				  .filter(inter->inter.getCreatedAt().getYear()==2020)
				  .collect(Collectors.counting());
		Long internships2021=interRepo.findAll()
				  .stream()
				  .filter(inter->inter.getCreatedAt().getYear()==2021)
				  .collect(Collectors.counting());
		Long defenses2017=defenseRepo.findAll()
				  .stream()
				  .filter(def->def.getCreatedAt().getYear()==2017)
				  .collect(Collectors.counting());
		Long defenses2018=defenseRepo.findAll()
				  .stream()
				  .filter(def->def.getCreatedAt().getYear()==2018)
				  .collect(Collectors.counting());
		Long defenses2019=defenseRepo.findAll()
				  .stream()
				  .filter(def->def.getCreatedAt().getYear()==2019)
				  .collect(Collectors.counting());
		Long defenses2020=defenseRepo.findAll()
				  .stream()
				  .filter(def->def.getCreatedAt().getYear()==2020)
				  .collect(Collectors.counting());
		Long defenses2021=defenseRepo.findAll()
				  .stream()
				  .filter(def->def.getCreatedAt().getYear()==2021)
				  .collect(Collectors.counting());
		StatisticsAdminResponse response=new StatisticsAdminResponse(adminsNumber, teachersNumber, studentsNumber, internshipsNumber, defensesNumber, internships2017, internships2018, internships2019, internships2020, internships2021, defenses2017, defenses2018, defenses2019, defenses2020, defenses2021);

		return new ResponseEntity<StatisticsAdminResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/teacher")
	public ResponseEntity<?> getStatisticsForTeacher(){
		User userDetails=(User)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		int framedInternships=userDetails.getFramedInterships().size();
		int reportedDefenses=userDetails.getReportedDefenses().size();
		int chairedDefenses=userDetails.getChairedDefenses().size();
		int panelsNumber=userDetails.getPanels().size();
		int createdOffers=userDetails.getCreatedOffers().size();
		Long internships2017=userDetails.getFramedInterships().stream()
															  .filter(inter->inter.getCreatedAt().getYear()==2017)
															  .collect(Collectors.counting());
		Long internships2018=userDetails.getFramedInterships().stream()
				  .filter(inter->inter.getCreatedAt().getYear()==2018)
				  .collect(Collectors.counting());
		Long internships2019=userDetails.getFramedInterships().stream()
				  .filter(inter->inter.getCreatedAt().getYear()==2019)
				  .collect(Collectors.counting());
		Long internships2020=userDetails.getFramedInterships().stream()
				  .filter(inter->inter.getCreatedAt().getYear()==2020)
				  .collect(Collectors.counting());
		Long internships2021=userDetails.getFramedInterships().stream()
				  .filter(inter->inter.getCreatedAt().getYear()==2021)
				  .collect(Collectors.counting());
		StatisticssTeacherResponse response=new StatisticssTeacherResponse(framedInternships, reportedDefenses, chairedDefenses, panelsNumber, createdOffers, internships2017, internships2018, internships2019, internships2020, internships2021);
		
		return new ResponseEntity<StatisticssTeacherResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/student")
	public ResponseEntity<?> getStatisticsForStudent(){
		User userDetails=(User)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		int createdOffers=userDetails.getCreatedOffers().size();
		Long requestedInternships=userDetails.getPassedInterships()
											 .stream()
											 .filter(inter->inter.getConfirmation()==0)
											 .collect(Collectors.counting());
		Long confirmedInternships=userDetails.getPassedInterships()
				 .stream()
				 .filter(inter->inter.getConfirmation()==1)
				 .collect(Collectors.counting());
		
		Long internships2017=userDetails.getPassedInterships().stream()
															  .filter(inter->inter.getCreatedAt().getYear()==2017)
															  .collect(Collectors.counting());

		Long internships2018=userDetails.getPassedInterships().stream()
				  											  .filter(inter->inter.getCreatedAt().getYear()==2018)
				  											  .collect(Collectors.counting());
		Long internships2019=userDetails.getPassedInterships().stream()
				  											  .filter(inter->inter.getCreatedAt().getYear()==2019)
				  											  .collect(Collectors.counting());
		Long internships2020=userDetails.getPassedInterships().stream()
				  											  .filter(inter->inter.getCreatedAt().getYear()==2020)
				  											  .collect(Collectors.counting());
		Long internships2021=userDetails.getPassedInterships().stream()
				  											  .filter(inter->inter.getCreatedAt().getYear()==2021)
				  											  .collect(Collectors.counting());
		StatisticsStudentResponse response=new StatisticsStudentResponse(requestedInternships, confirmedInternships, createdOffers, internships2017, internships2018, internships2019, internships2020, internships2021);
		return new ResponseEntity<StatisticsStudentResponse>(response,HttpStatus.OK);
	}

}
