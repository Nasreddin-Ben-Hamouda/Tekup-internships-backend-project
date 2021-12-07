package com.internships.rest.data.models;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;

@Entity
@Data
@Table(name = "defenses")
public class Defense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@Column(nullable = false)
	private LocalDate date;
	@Column(nullable = false)
	private LocalTime startTime;
	@Column(nullable = false)
	private LocalTime endTime;
	@OneToOne
	@JoinColumn(name = "intership_id")
	private Internship internship;
	@ManyToOne
	@JoinColumn(name = "panel_id")
	private Panel panel;
	@ManyToOne
	@JoinColumn(name = "reporter_id")
	private User reporter;
	@ManyToOne
	@JoinColumn(name = "president_id")
	private User president;
	@OneToOne(mappedBy = "defense",cascade = CascadeType.REMOVE)
	private DefenseDecision decision;
	@OneToMany(mappedBy = "defense",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<DefenseAttachement> attachements;
	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
