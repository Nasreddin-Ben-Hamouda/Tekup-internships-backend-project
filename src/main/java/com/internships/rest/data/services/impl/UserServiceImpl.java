package com.internships.rest.data.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.internships.rest.data.dto.RoleDTO;
import com.internships.rest.data.dto.UserDTO;
import com.internships.rest.data.models.Class;
import com.internships.rest.data.models.Role;
import com.internships.rest.data.models.User;
import com.internships.rest.data.repositories.RoleRepository;
import com.internships.rest.data.repositories.UserRepository;
import com.internships.rest.data.services.UserService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	private ModelMapper mapper;
	private UserRepository userRepo;
	private RoleRepository roleRepo;
	private PasswordEncoder encoder;

	@Override
	public User findById(Long id) {
		Optional<User> user=userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
		
	}

	@Override
	public String create(UserDTO user) {
		String result=null;
		User checkUser=userRepo.findByEmail(user.getEmail());
		if(checkUser==null) {
			User newUser=mapper.map(user, User.class);
			newUser.setPassword(encoder.encode(newUser.getPassword()));
			newUser=userRepo.save(newUser);
			if(newUser==null)
				result="User not added,try again";
		}else {
			result="Email already used by another user";
		}
		return result;
	}

	@Override
	public String update(UserDTO user, Long id) {
		String result=null;
		User oldUser=this.findById(id);
		if(oldUser!=null) {
			User checkUser=userRepo.findByEmail(user.getEmail());
			if(checkUser==null || checkUser.getEmail().equals(oldUser.getEmail())) {
				oldUser.setFirstName(user.getFirstName());
				oldUser.setLastName(user.getLastName());
				oldUser.setEmail(user.getEmail());
				oldUser.setCinNumber(user.getCinNumber());
				oldUser.setPhone(user.getPhone());
				oldUser.setClasse(user.getClasseDTO()!=null?mapper.map(user.getClasseDTO(), Class.class):null);
				oldUser.setRole(user.getRoleDTO()!=null?mapper.map(user.getRoleDTO(),Role.class):null);
				if(user.getPassword()!=null) {
					oldUser.setPassword(encoder.encode(user.getPassword()));
				}
				oldUser=userRepo.save(oldUser);
				System.out.println(user);
				if(oldUser==null)
					result="User not updated,try again";
			}else {
				result="Email already used by another user";
			}
		}else {
			result="User Not found";
		}
		
		return result;
	}

	@Override
	public String delete(Long id) {
		String result=null;
		User user=this.findById(id);
		if(user!=null) {
			userRepo.delete(user);
		}else {
			result="User not found";
		}
		return result;
	}

	@Override
	public List<UserDTO> list() {
		return userRepo.findAll().stream()
								  .map(user->mapper.map(user, UserDTO.class))
								  .collect(Collectors.toList());
	}

	@Override
	public List<RoleDTO> listRoles() {
		return roleRepo.findAll().stream()
				  .map(role->mapper.map(role, RoleDTO.class))
				  .collect(Collectors.toList());
	}

}
