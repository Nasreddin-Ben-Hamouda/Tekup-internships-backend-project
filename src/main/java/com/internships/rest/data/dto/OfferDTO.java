package com.internships.rest.data.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

import com.internships.rest.data.models.OfferAttachement;
import com.internships.rest.data.models.User;

import lombok.Data;
@Data
public class OfferDTO {
	

	private Long id;
	private String title;
	private String description;
	private String coverPhotoPath;
	private int confirmation;
	private UserDTO createdByDTO;
	private UserDTO updatedByDTO;
	private List<MultipartFile> attachmentsRequest;
	private List<OfferAttachementsDTO> attachementsDTO;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public void setCreatedBy(User user) {
    	if(user!=null) {
			ModelMapper mapper=new ModelMapper();
			this.createdByDTO=mapper.map(user, UserDTO.class);
    	}
	}
	public void setUpdatedBy(User user) {
    	if(user!=null) {
			ModelMapper mapper=new ModelMapper();
			this.updatedByDTO=mapper.map(user, UserDTO.class);
    	}
	}
	
	public void setAttachements(List<OfferAttachement> attachements) {
		if(attachements!=null) {
			ModelMapper mapper=new ModelMapper();
			this.attachementsDTO= attachements.stream()
							   .map(attachement->mapper.map(attachement,OfferAttachementsDTO.class))
							   .collect(Collectors.toList());
		}
		
	}

}
