package com.internships.rest.data.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@Column(nullable = false)
	private String title;	//[STUDENT,TEACHER,ADMIN]
	@OneToMany(mappedBy = "role",cascade = CascadeType.REMOVE )
	private List<User> users;

}
