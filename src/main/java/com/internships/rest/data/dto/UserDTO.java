package com.internships.rest.data.dto;

import java.time.LocalDate;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import com.internships.rest.data.models.Class;
import com.internships.rest.data.models.Role;


import lombok.Data;


@Data
public class UserDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int cinNumber;
    private AddressDTO addressDTO;
    private int phone;
    private LocalDate birthday;
    private int status;
    private RoleDTO roleDTO;
    private ClassDTO classeDTO;
    public void setRole(Role role) {
    	if(role!=null) {
			ModelMapper mapper=new ModelMapper();
			this.roleDTO=mapper.map(role, RoleDTO.class);
    	}
	}
    public void setClasse(Class classe) {
    	if(classe!=null) {
			ModelMapper mapper=new ModelMapper();
			this.classeDTO=mapper.map(classe, ClassDTO.class);
    	}
	}
    public void setAddress(JSONObject adr) {
    	if(adr!=null) {
			this.addressDTO=new AddressDTO(
										adr.has("city")?adr.getString("city"):null,
										adr.has("street")?adr.getString("street"):null,
										adr.has("code")? adr.getInt("code"):0);
    	}
    	
	}
    

}
