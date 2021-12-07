package com.internships.rest.data.dto;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import com.internships.rest.data.models.Section;
import com.internships.rest.data.models.User;
import lombok.Data;

@Data
public class ClassDTO {
	private Long id;
	private String name;
	private int level;
	private SectionDTO sectionDTO;
	private List<UserDTO> usersDTO;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	public void setSection(Section section) {
		if(section!=null) {
			this.sectionDTO=new SectionDTO();
			if(section.getId()!=null) 
				this.sectionDTO.setId(section.getId());
			if(section.getTitle()!=null)
				this.sectionDTO.setTitle(section.getTitle());
		}
	}
	public void setUsers(List<User> users) {
		if(users!=null) {
			ModelMapper mapper=new ModelMapper();
			this.usersDTO=users.stream()
					   .map(u->mapper.map(u,UserDTO.class))
					   .collect(Collectors.toList());
		}
	}

}
