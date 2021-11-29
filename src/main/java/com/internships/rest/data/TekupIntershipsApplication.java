package com.internships.rest.data;



/*import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import org.json.JSONObject;

import com.internships.rest.data.models.Role;
import com.internships.rest.data.models.User;
import com.internships.rest.data.repositories.RoleRepository;
import com.internships.rest.data.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
*/

import lombok.AllArgsConstructor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;






@SpringBootApplication

@AllArgsConstructor
public class TekupIntershipsApplication {
	
	  /* private UserRepository repo;
	   private RoleRepository roleRep;
	   private PasswordEncoder encoder;
	  
	   @PostConstruct
	    public void init() {
		   //create roles and save them on database
		    Role adminRole=new Role();
		    Role teacherRole=new Role();
		    Role studentRole=new Role();
		    adminRole.setTitle("ADMIN");
		    teacherRole.setTitle("TEACHER");
		    studentRole.setTitle("STUDENT");
		    adminRole=roleRep.save(adminRole);
		    teacherRole=roleRep.save(teacherRole);
		    studentRole=roleRep.save(studentRole);
		    //create users and save them on database with roles
		    //String adr="{street:'tastour',code:7016}";
		    HashMap<String,String> mp=new HashMap<>();
	        mp.put("street", "tastour1");
	        mp.put("code", "7016");
	    	User admin=new User();
	    	admin.setFirstName("admin");
	    	admin.setLastName("admin");
	    	admin.setEmail("admin@admin.com");
	    	admin.setPassword(encoder.encode("admin123"));
	    	admin.setRole(adminRole);
	    	admin.setAddress(new JSONObject(mp));
	    	User teacher=new User();
	    	teacher.setFirstName("teacher");
	    	teacher.setLastName("teacher");
	    	teacher.setEmail("teacher@teacher.com");
	    	teacher.setPassword(encoder.encode("teacher123"));
	    	teacher.setRole(teacherRole);
	    	teacher.setAddress(new JSONObject(mp));
	    	User student=new User();
	    	student.setFirstName("student");
	    	student.setLastName("student");
	    	student.setEmail("student@student.com");
	    	student.setPassword(encoder.encode("student123"));
	    	student.setRole(studentRole);
	    	student.setAddress(new JSONObject(mp));
	    	List<User> users=new ArrayList<User>(Arrays.asList(admin,teacher,student));
	        repo.saveAll(users);
		  
	    }*/
	public static void main(String[] args) {
		SpringApplication.run(TekupIntershipsApplication.class, args);
	}

}
