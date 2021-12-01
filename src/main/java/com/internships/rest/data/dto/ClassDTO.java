package com.internships.rest.data.dto;


import org.modelmapper.ModelMapper;


import com.internships.rest.data.models.Section;
import lombok.Data;

@Data
public class ClassDTO {
	private Long id;
	private String name;
	private int level;
	private SectionDTO sectionDTO;
	public void setSection(Section section) {
		if(section!=null) {
			ModelMapper mapper=new ModelMapper();
			this.sectionDTO=mapper.map(section, SectionDTO.class);
		}
	}

}
