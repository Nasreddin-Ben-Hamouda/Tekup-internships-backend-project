package com.internships.rest.data.dto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import lombok.Data;
import com.internships.rest.data.models.Class;
@Data
public class SectionDTO {
	private Long id;
	private String title;
	private List<ClassDTO> classesDTO;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	public void setClasses(List<Class> classes) {
		if(classes!=null) {
			ModelMapper mapper=new ModelMapper();
			this.classesDTO=classes.stream()
					   .map(c->mapper.map(c,ClassDTO.class))
					   .collect(Collectors.toList());
		}
	}
}
