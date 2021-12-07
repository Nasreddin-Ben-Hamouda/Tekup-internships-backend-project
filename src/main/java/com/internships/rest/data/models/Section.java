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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@Entity
@Data
@Table(name = "sections")
public class Section {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@Column(nullable = false)
	private String title;	//[GLSI,DSEN...]
	@OneToMany(mappedBy = "section",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER )
	private List<Class> classes;
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
