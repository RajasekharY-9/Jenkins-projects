package com.insta.service;

import java.util.List;

import com.insta.dto.UserDTO;
import com.insta.entity.User;
import com.insta.util.UserException;

public interface UserService {

	public User registerUser(User user) throws UserException;

	public User findUserById(Integer id) throws UserException;

	public User findUserByProfile(String token) throws UserException;;

	public User findUserByUsername(String username) throws UserException;

	public String followUser(Integer reqUserId, Integer followUserId) throws UserException;

	public String unfollowUser(Integer reqUserId, Integer followUserId) throws UserException;

	public List<User> findUserByIds(List<Integer> userIds) throws UserException;

	//public List<User> searchUser(String query) throws UserException;

	public User updateUserDetails(User updateUser, User existingUser) throws UserException;

	
	
	
	
	
	
	
	
	
	
}
