package com.insta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insta.dto.UserDTO;
import com.insta.entity.User;
import com.insta.service.UserService;
import com.insta.util.UserException;



@RestController
@Validated
public class InstaApi {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/signup")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserException{
		
	User us=userService.registerUser(user);
	
return new ResponseEntity<>(us,HttpStatus.CREATED);
		
	}
	@GetMapping("/user/id/{id}")
	public ResponseEntity<User> findUserById(@PathVariable Integer id) throws UserException{
		
		User us=userService.findUserById(id);
		
	return new ResponseEntity<>(us,HttpStatus.OK);
			
		}
	@GetMapping("/user/name/{username}")
public ResponseEntity<User> findUserByUsername(@PathVariable String username) throws UserException{
		
		User us=userService.findUserByUsername(username);
		
	return new ResponseEntity<>(us,HttpStatus.OK);
			
		}

public  String followUser(Integer reqUserId, Integer followUserId) throws UserException{
	
	String us=userService.followUser(reqUserId,followUserId);
	
return us;
		
	}
	
public  String unfollowUser(Integer reqUserId, Integer followUserId) throws UserException{
	
	String us=userService.unfollowUser(reqUserId,followUserId);
	
return us;
		
	}
                 
@GetMapping("/user/id/all/{userIds}")
public  List<User> findUserByIds(@PathVariable List<Integer> userIds) throws UserException{
	
	List<User> us=userService.findUserByIds(userIds);
	
return us;
		
	}
       
	
}
