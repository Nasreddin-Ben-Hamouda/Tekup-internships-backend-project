package com.internships.rest.data.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.internships.rest.data.dto.SectionDTO;
import com.internships.rest.data.models.Section;
import com.internships.rest.data.repositories.SectionRepository;
import com.internships.rest.data.services.SectionService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class SectionServiceImpl implements SectionService{

	private ModelMapper mapper;
	private SectionRepository rep;
	
	
	@Override
	public Section findById(Long id) {
		Optional<Section> section=rep.findById(id);
		if(section.isPresent())
			return section.get();
		return null;
	}

	@Override
	public SectionDTO create(SectionDTO section) {
		SectionDTO returnedSectionDTO=null;
		Section newSection=mapper.map(section, Section.class);
		newSection=rep.save(newSection);
		if(newSection!=null)
			returnedSectionDTO=mapper.map(newSection, SectionDTO.class);
		return returnedSectionDTO;
	}

	@Override
	public SectionDTO update(SectionDTO section, Long id) {
		SectionDTO returnedSectionDTO=null;
		Section oldSection=this.findById(id);
		if(oldSection!=null) {
			oldSection.setTitle(section.getTitle());
			oldSection=rep.save(oldSection);
			returnedSectionDTO=mapper.map(oldSection, SectionDTO.class);
		}
		return returnedSectionDTO;
	}

	@Override
	public String delete(Long id) {
		Section section=this.findById(id);
		if(section!=null) {
			if(section.getClasses().size()<=0) {
				rep.delete(section);
				return null;
			}else {
				return "This section related with classes";
			}
		}
		return "Section not found";
	}

	@Override
	public List<SectionDTO> list() {
		
		return rep.findAll()
				   .stream()
				   .map(section->mapper.map(section, SectionDTO.class))
				   .collect(Collectors.toList());
	}

}
