package com.internships.rest.data.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.internships.rest.data.dto.ClassDTO;
import com.internships.rest.data.models.Class;
import com.internships.rest.data.models.Section;
import com.internships.rest.data.repositories.ClassRepository;
import com.internships.rest.data.services.ClassService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ClassServiceImpl implements ClassService {

	private ModelMapper mapper;
	private ClassRepository rep;
	@Override
	public Class findById(Long id) {
		Optional<Class> classe=rep.findById(id);
		if(classe.isPresent())
			return classe.get();
		return null;
	}

	@Override
	public ClassDTO create(ClassDTO classe) {
		ClassDTO returnedClassDTO=null;
		Class newClass=mapper.map(classe, Class.class);
		newClass=rep.save(newClass);
		if(newClass!=null)
			returnedClassDTO=mapper.map(newClass, ClassDTO.class);
		return returnedClassDTO;
	}

	@Override
	public ClassDTO update(ClassDTO classe, Long id) {
		ClassDTO returnedClassDTO=null;
		Class oldClass=this.findById(id);
		if(oldClass!=null) {
			oldClass.setName(classe.getName());
			oldClass.setLevel(classe.getLevel());
			oldClass.setSection(mapper.map(classe.getSectionDTO(),Section.class));
			oldClass=rep.save(oldClass);
			returnedClassDTO=mapper.map(oldClass, ClassDTO.class);
		}
		return returnedClassDTO;
	}

	@Override
	public String delete(Long id) {
		Class classe=this.findById(id);
		
		if(classe!=null) {
			if(classe.getUsers().size()<=0) {
				rep.delete(classe);
				return null;
			}else {
				return "This Class related with students";
			}
		}
		return "Class not found";
	}

	@Override
	public List<ClassDTO> list() {
		return rep.findAll()
				   .stream()
				   .map(classe->mapper.map(classe, ClassDTO.class))
				   .collect(Collectors.toList());
	}

}
