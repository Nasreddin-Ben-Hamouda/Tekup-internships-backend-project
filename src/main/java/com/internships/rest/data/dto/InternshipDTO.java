package com.internships.rest.data.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

import com.internships.rest.data.models.InternshipAttachement;
import com.internships.rest.data.models.User;

import lombok.Data;

@Data
public class InternshipDTO {
	
	private Long id;
	private int type;
	private String subjectDescription;
	private int confirmation;
	private int duration;
	private LocalDate startDate;
	private LocalDate endDate;
	private UserDTO universityFramerDTO;
	private List<UserDTO> studentsDTO;
	private List<MultipartFile> attachementsRequest;
	private List<InternshipAttachementsDTO> attachementsDTO;
    private CompanyDTO companyDTO; 
    private CompanyFramerDTO companyFramerDTO; 
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public void setUniversityFramer(User user) {
    	if(user!=null) {
			ModelMapper mapper=new ModelMapper();
			this.universityFramerDTO=mapper.map(user, UserDTO.class);
    	}
	}
	

	public void setAttachements(List<InternshipAttachement> attachements) {
		if(attachements!=null) {
			ModelMapper mapper=new ModelMapper();
			this.attachementsDTO= attachements.stream()
							   .map(attachement->mapper.map(attachement,InternshipAttachementsDTO.class))
							   .collect(Collectors.toList());
		}
		
	}
	
	public void setStudents(List<User> students) {
		if(students!=null) {
			ModelMapper mapper=new ModelMapper();
			this.studentsDTO= students.stream()
							   .map(student->mapper.map(student,UserDTO.class))
							   .collect(Collectors.toList());
		}
		
	}
	
	  public void setCompany(JSONObject company) {
	    	if(company!=null) {
				this.companyDTO=new CompanyDTO(
											company.has("name")?company.getString("name"):null,
											company.has("domain")?company.getString("domain"):null,
											company.has("address")? company.getString("address"):null,
											company.has("website")? company.getString("website"):null);
	    	}
	    	
	}
	  public void setCompanyFramer(JSONObject framer) {
	    	if(framer!=null) {
				this.companyFramerDTO=new CompanyFramerDTO(
											framer.has("name")?framer.getString("name"):null,
											framer.has("function")?framer.getString("function"):null,
											framer.has("phone")? framer.getInt("phone"):0,
											framer.has("email")? framer.getString("email"):null);
	    	}
	    	
	}

}
