package com.internships.rest.data.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "defense_attachements")
public class DefenseAttachement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@Column(nullable = false)
	private String title;
	private String path;
	@ManyToOne
	@JoinColumn(name = "defense_id")
	private Defense defense;
    @Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
    @Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
