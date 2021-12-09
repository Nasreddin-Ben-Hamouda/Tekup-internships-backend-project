package com.internships.rest.data.services;

import java.util.List;

import com.internships.rest.data.dto.InternshipDTO;
import com.internships.rest.data.models.Internship;

public interface InternshipService {

	Internship findById(Long id);
	String create(InternshipDTO internship);
	String update(InternshipDTO internship,Long id);
	Boolean delete(Long id);
	List<InternshipDTO> list ();
	String confirm(Long id);
}
