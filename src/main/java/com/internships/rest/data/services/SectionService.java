package com.internships.rest.data.services;

import java.util.List;
import com.internships.rest.data.dto.SectionDTO;
import com.internships.rest.data.models.Section;

public interface SectionService {
	
	
	Section findById(Long id);
	SectionDTO create(SectionDTO section);
	SectionDTO update(SectionDTO section,Long id);
	String delete(Long id);
	List<SectionDTO> list ();

}
