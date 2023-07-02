package com.insta.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.insta.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{

;

	public Optional<User> findByEmail(String email);
	
	
	public Optional<User> findByUsername(String username);
	
	@Query("SELECT u from User u where u.id IN :users")
	public List<User> findAllUsersByUserIds(@Param("users") List<Integer> userIds);
	
	//@Query("SELECT DISTINCT u from User u where u.username LIKE %query% or u.email LIKE %query%")
//	public List<User> findByQuery(@Param("query") String query );

	
	
}
