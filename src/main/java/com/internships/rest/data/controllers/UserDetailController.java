package com.internships.rest.data.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.internships.rest.data.dto.JwtResponse;
import com.internships.rest.data.dto.UpdatePasswordRequest;
import com.internships.rest.data.dto.UserDTO;
import com.internships.rest.data.models.User;
import com.internships.rest.data.repositories.UserRepository;
import com.internships.rest.data.services.FileSaverService;
import com.internships.rest.data.util.JwtUtil;

import lombok.AllArgsConstructor;

//@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class UserDetailController {
	private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    private ModelMapper mapper;
    private UserRepository userRepo;
    private PasswordEncoder encoder;
    private FileSaverService fileSaverService;
   
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserDTO user) throws Exception {
    	
    	Authentication auth;
    	try {
                    auth=authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
        } catch (Exception ex) {
            return new ResponseEntity<String>("Invalid username/password",HttpStatus.NOT_FOUND);
        }
    	String jwt = jwtUtil.generateToken(user.getEmail());
        User userDetails=(User) auth.getPrincipal();
       
        return new ResponseEntity<JwtResponse>(new JwtResponse(jwt,mapper.map(userDetails, UserDTO.class)),HttpStatus.OK);
     
    }

    @GetMapping("/whoami")
    public UserDTO getAuthenticatedUser() throws Exception {
  
        User userDetails=(User)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return mapper.map(userDetails, UserDTO.class);
    }
    
    @PutMapping("/updateUserCredentials")
    public ResponseEntity<?> updateUserCredentials(@RequestBody UserDTO user) {
    	User userDetails=(User)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
    	if(!userDetails.getEmail().equals(user.getEmail())) {
    		User checkUser=userRepo.findByEmail(user.getEmail());
    		if(checkUser!=null)
    			return new ResponseEntity<String>("Email already used by another user",HttpStatus.CONFLICT);
    		else
    			userDetails.setEmail(user.getEmail());
    	}
    	userDetails.setFirstName(user.getFirstName());
    	userDetails.setLastName(user.getLastName());
    	userDetails.setPhone(user.getPhone());
    	userDetails.setBirthday(user.getBirthday());
    	userDetails.setCinNumber(user.getCinNumber());
    	userDetails=userRepo.save(userDetails);
    	return new ResponseEntity<UserDTO>(mapper.map(userDetails, UserDTO.class),HttpStatus.OK);
  
    }
    
    @PutMapping("/updateUserPassword")
    public ResponseEntity<?> updateUserPassword(@RequestBody  UpdatePasswordRequest user) {
    	User userDetails=(User)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
    	if(encoder.matches(user.getOldPassword(),userDetails.getPassword())) {
    		userDetails.setPassword(encoder.encode(user.getNewPassword()));
    		userDetails=userRepo.save(userDetails);
    		return new ResponseEntity<UserDTO>(mapper.map(userDetails, UserDTO.class),HttpStatus.OK);
    	}else {
    		return new ResponseEntity<String>("The old password is incorrect ",HttpStatus.BAD_REQUEST);
    	}
    }
    
    @PutMapping("/updateUserPhoto")
    public ResponseEntity<?> updateUserPhoto(@RequestParam("file") MultipartFile file ){
    	User userDetails=(User)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
	    String folder="uploads/users/";
		try {
			String photo=fileSaverService.saveFile(folder, file);
			if(userDetails.getPhoto()!=null) {
				fileSaverService.deleteFile(folder,userDetails.getPhoto());
			}
			userDetails.setPhoto(photo);
			userDetails=userRepo.save(userDetails);
			return new ResponseEntity<UserDTO>(mapper.map(userDetails,UserDTO.class),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error saving photo",HttpStatus.BAD_REQUEST);
		}

    }
}
