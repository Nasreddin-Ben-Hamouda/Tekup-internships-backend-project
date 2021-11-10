package com.internships.rest.data;

/*
import java.util.HashMap;
import javax.annotation.PostConstruct;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import com.internships.rest.data.models.User;
import com.internships.rest.data.repositories.UserRepository;
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication

public class TekupIntershipsApplication {
	
	/*@Autowired
	   private UserRepository repo;
	   @PostConstruct
	    public void initUsers() {
		    String adr="{street:'tastour',code:7016}";
		    HashMap<String,String> mp=new HashMap<>();
	        mp.put("street", "tastour1");
	        mp.put("code", "7016");
	    	User user=new User();
	    	user.setFirstName("hamza");
	    	user.setLastName("ben hamouda");
	    	user.setCinNumber(11394845);
	    	
	    	user.setAddress(new JSONObject(mp));
	        repo.save(user);
		    System.out.println(repo.findAll().get(0).getAddress().get("street"));
	    }*/
	public static void main(String[] args) {
		SpringApplication.run(TekupIntershipsApplication.class, args);
	}

}
