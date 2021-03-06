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
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "classes")
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@Column(nullable = false)
	private String name;
	private int level;//[1,2,3,4,5]
	@ManyToOne
    @JoinColumn(name="section_id")
	private Section section;
	@OneToMany(mappedBy = "classe",cascade = CascadeType.REMOVE ,fetch = FetchType.EAGER)
	private List<User> users;
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
