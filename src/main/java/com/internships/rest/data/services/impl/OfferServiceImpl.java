package com.internships.rest.data.services.impl;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.internships.rest.data.dto.OfferDTO;
import com.internships.rest.data.models.Offer;
import com.internships.rest.data.models.OfferAttachement;
import com.internships.rest.data.models.User;
import com.internships.rest.data.repositories.OfferAttachementRepository;
import com.internships.rest.data.repositories.OfferRepository;
import com.internships.rest.data.services.FileSaverService;
import com.internships.rest.data.services.OfferService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class OfferServiceImpl implements OfferService {
	
	private ModelMapper mapper;
	private OfferRepository offerRepo;
	private OfferAttachementRepository offerAttachementRepo;
	private FileSaverService fileSaverService;
	public static final String folder="uploads/offers/";

	@Override
	public OfferDTO create(OfferDTO offer) {
		OfferDTO offerReturned=null;
		User userDetails=(User)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		Offer newOffer=mapper.map(offer, Offer.class);
		newOffer.setCreatedBy(userDetails);
		newOffer.setUpdatedBy(userDetails);
		newOffer=offerRepo.save(newOffer);
		if(newOffer!=null) {
			offerReturned=mapper.map(newOffer, OfferDTO.class);
			if(offer.getAttachmentsRequest()!=null) {
				for (MultipartFile file:offer.getAttachmentsRequest()) {
					try {
							String fileName=fileSaverService.saveFile(folder, file);
							OfferAttachement offerAttach=new OfferAttachement();
							offerAttach.setTitle("No title for now");
							offerAttach.setPath(fileName);
							offerAttach.setOffer(newOffer);
							offerAttachementRepo.save(offerAttach);
					
					} catch (Exception e) {
						System.out.println("erreur saving file");
					}
				}
			}
		}
		
		return offerReturned;
	}

	@Override
	public OfferDTO update(OfferDTO offer, Long id) {
		OfferDTO offerReturned=null;
		User userDetails=(User)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		Offer oldOffer=this.findById(id);
		if(oldOffer!=null) {
			oldOffer.setTitle(offer.getTitle());
			oldOffer.setDescription(offer.getDescription());
			oldOffer.setUpdatedBy(userDetails);
			oldOffer=offerRepo.save(oldOffer);
			if(oldOffer!=null) {
				offerReturned=mapper.map(oldOffer, OfferDTO.class);
				for(OfferAttachement attach:oldOffer.getAttachements()) {
					try {
						fileSaverService.deleteFile(folder, attach.getPath());
						offerAttachementRepo.delete(attach);
					} catch (IOException e) {
						System.out.println("failed deleting file");
					}
				}
				if(offer.getAttachmentsRequest()!=null) {
					for (MultipartFile file:offer.getAttachmentsRequest()) {
						try {
								String fileName=fileSaverService.saveFile(folder, file);
								OfferAttachement offerAttach=new OfferAttachement();
								offerAttach.setTitle("No title for now");
								offerAttach.setPath(fileName);
								offerAttach.setOffer(oldOffer);
								offerAttachementRepo.save(offerAttach);
						
						} catch (Exception e) {
							System.out.println("erreur saving file");
						}
					}
				}
			}
		}
		
		return offerReturned;
	}

	@Override
	public Boolean delete(Long id) {
		Offer offer=this.findById(id);
		if(offer!=null) {
				for(OfferAttachement attach:offer.getAttachements()) {
					try {
						fileSaverService.deleteFile(folder, attach.getPath());
					} catch (IOException e) {
						System.out.println("failed deleting file");
					}
				}
			
			offerRepo.delete(offer);
			return true;
		}
			
		return false;
	}

	@Override
	public List<OfferDTO> list() {
		List<OfferDTO> offers=offerRepo.findAll()
										         .stream()
										         .map(offer->mapper.map(offer,OfferDTO.class))
										         .sorted(Comparator.comparing(OfferDTO::getCreatedAt).reversed())
										         .collect(Collectors.toList());
		return offers;
	}

	@Override
	public Offer findById(Long id) {
		Optional<Offer> offer=offerRepo.findById(id);
		if(offer.isPresent())
			return offer.get();
		return null;
	}

}
