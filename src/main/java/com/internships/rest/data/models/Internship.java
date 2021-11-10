package com.internships.rest.data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import org.json.JSONObject;

import com.internships.rest.data.util.JSONObjectConverter;

import lombok.Data;

@Entity
@Data
@Table(name = "internships")
public class Internship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@Column(columnDefinition = "int default 1")
	private int type;	//[1=>First,2=>Second,3=>PFE,4=>Other]
	@Column(columnDefinition = "TEXT")
	private String subjectDescription;
	@Column(columnDefinition = "int default 0")
	private int confirmation;	//[0=>not confirmed yet,1=>confirmed]
	private int duration;	//[number of weeks]
	private LocalDate startDate;
	private LocalDate endDate;
	@OneToOne(mappedBy = "internship",cascade = CascadeType.REMOVE)
	private Defense defense;
	@ManyToOne
	@JoinColumn(name = "university_framer_id")
	private User universityFramer;
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "students_internships",
	joinColumns = @JoinColumn(name="internship_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<User> students;
	@OneToMany(mappedBy = "internship",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<InternshipAttachement> attachements;
	@Column(columnDefinition = "longtext")
    @Convert(converter= JSONObjectConverter.class)
    private JSONObject company;    //[name,domain,address,WebSite]
	@Column(columnDefinition = "longtext")
    @Convert(converter= JSONObjectConverter.class)
    private JSONObject companyFramer;    //[name,function,phone,e-mail,fax]
	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
    @Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
