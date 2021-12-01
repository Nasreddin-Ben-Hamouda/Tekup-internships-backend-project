package com.internships.rest.data;



/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import com.internships.rest.data.dto.AddressDTO;
import com.internships.rest.data.dto.ClassDTO;
import com.internships.rest.data.dto.RoleDTO;
import com.internships.rest.data.dto.UserDTO;
import com.internships.rest.data.models.Class;
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
	   private ModelMapper mapper;
	  
	   @PostConstruct
	    public void init() {
		  /* //create roles and save them on database
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
	        */
		   // test the mapping of UserDTO to User class
		    /*RoleDTO adminRole=new RoleDTO();
		    adminRole.setTitle("ADMIN");
		    UserDTO admin=new UserDTO();
	    	admin.setFirstName("admin");
	    	admin.setLastName("admin");
	    	admin.setEmail("admin@admin.com");
	    	admin.setPassword(encoder.encode("admin123"));
	    	admin.setRoleDTO(adminRole);
	    	admin.setAddressDTO(new AddressDTO("HHH", "HHH", 7016));
	    	ClassDTO classe=new ClassDTO();
	    	classe.setName("glsi-b");
	    	admin.setClasseDTO(classe);
	    	System.out.println(mapper.map(admin, User.class));*/
	   /*}*/
	public static void main(String[] args) {
		SpringApplication.run(TekupIntershipsApplication.class, args);
	}

}
