package com.internships.rest.data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.json.JSONObject;

import com.internships.rest.data.util.JSONObjectConverter;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	private int cinNumber;
    @Column(columnDefinition = "longtext")
    @Convert(converter= JSONObjectConverter.class)
    private JSONObject address;//[city,street,code]
    private int phone;
    private LocalDate birthday;
    @Column(columnDefinition = "int default 1")
    private int status;//[1=>active,2=>blocked]
    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
	@ManyToOne
    @JoinColumn(name="class_id")
    private Class classe;//as student
	@OneToMany(mappedBy = "createdBy",cascade = CascadeType.ALL)
	private List<Offer> createdOffers;
	@OneToMany(mappedBy = "updatedBy",cascade = CascadeType.ALL)
	private List<Offer> updatedOffers;
	@OneToMany(mappedBy = "universityFramer",cascade = CascadeType.ALL)
	private List<Internship> framedInterships;//as teacher
	@OneToMany(mappedBy = "reporter",cascade = CascadeType.ALL)
	private List<Defense> reportedDefenses;//as teacher(reporter)
	@OneToMany(mappedBy = "president",cascade = CascadeType.ALL)
	private List<Defense> ChairedDefenses;//as teacher(president)
	@ManyToMany(mappedBy = "students",cascade = CascadeType.DETACH)
	private List<Internship> passedInterships;//as student
	@ManyToMany(mappedBy = "teachers",cascade = CascadeType.DETACH)
	private List<Panel> panels;//as teacher
    @Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
    @Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
