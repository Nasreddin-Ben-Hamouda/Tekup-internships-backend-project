package com.internships.rest.data.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;

@Entity
@Data
@Table(name = "offers")
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String coverPhotoPath;
	@Column(columnDefinition = "int default 0")
	private int confirmation;	//[0=>not confirmed yet,1=>confirmed]
	@ManyToOne
	@JoinColumn(name ="created_by")
	private User createdBy;
	@ManyToOne
	@JoinColumn(name ="updated_by")
	private User updatedBy;
	@OneToMany(mappedBy = "offer",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<OfferAttachement> attachements;
	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	

}
