package com.internships.rest.data.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.internships.rest.data.dto.InternshipDTO;
import com.internships.rest.data.models.Internship;
import com.internships.rest.data.repositories.InternshipAttachementRepository;
import com.internships.rest.data.repositories.InternshipRepository;
import com.internships.rest.data.services.InternshipService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class InternshipServiceImpl implements InternshipService {
	
	private ModelMapper mapper;
	private InternshipRepository interRepo;
	private InternshipAttachementRepository interAttachRepo;

	@Override
	public Internship findById(Long id) {
		Optional<Internship> internship=interRepo.findById(id);
		if(internship.isPresent()) {
			return internship.get();
		}
		return null;
	}

	@Override
	public String create(InternshipDTO internship) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(InternshipDTO internship, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InternshipDTO> list() {
		
		return interRepo.findAll().stream()
								   .map(intern->mapper.map(intern, InternshipDTO.class))
								   .collect(Collectors.toList());
	}

	@Override
	public String confirm(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
