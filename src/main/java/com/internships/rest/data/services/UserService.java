package com.internships.rest.data.services;

import java.util.List;

import com.internships.rest.data.dto.RoleDTO;
import com.internships.rest.data.dto.UserDTO;
import com.internships.rest.data.models.User;

public interface UserService {
	
	
	User findById(Long id);
	String create(UserDTO user);
	String update(UserDTO user,Long id);
	String delete(Long id);
	List<UserDTO> list ();
	List<RoleDTO> listRoles ();
	
}
