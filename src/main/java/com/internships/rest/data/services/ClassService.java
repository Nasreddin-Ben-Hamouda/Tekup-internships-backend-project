package com.internships.rest.data.services;

import java.util.List;

import com.internships.rest.data.dto.ClassDTO;
import com.internships.rest.data.models.Class;

public interface ClassService {
	Class findById(Long id);
	ClassDTO create(ClassDTO classe);
	ClassDTO update(ClassDTO classe,Long id);
	String delete(Long id);
	List<ClassDTO> list ();
}
