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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="panels")
public class Panel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@Column(nullable = false)
	private String name;
	@OneToMany(mappedBy = "panel",cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
	private List<Defense> Defenses;
	@OneToMany(mappedBy = "panel",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PanelDate> dates;
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "teachers_panels",
	joinColumns = @JoinColumn(name="panel_id"),
    inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	
	private List<User> teachers;
    @Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
    @Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
