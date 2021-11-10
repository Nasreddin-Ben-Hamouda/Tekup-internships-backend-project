package com.internships.rest.data.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.json.JSONObject;

import com.internships.rest.data.util.JSONObjectConverter;

import lombok.Data;

@Entity
@Data
@Table(name = "decisions")
public class DefenseDecision {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@Column(columnDefinition = "longtext")
    @Convert(converter= JSONObjectConverter.class)
    private JSONObject notes;//[reportNote,presentationNote,technicalNote]
	private double finalNote;
	private int mention;//[1=>Adjourned(Ajourné),2=>fair(Passable),3=>Pretty good(Assez bien),4=>Well(Bien),5=>Very well(Très bien),6=>Excellent]
	@OneToOne
	@JoinColumn(name = "defense_id")
	private Defense defense;
	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
