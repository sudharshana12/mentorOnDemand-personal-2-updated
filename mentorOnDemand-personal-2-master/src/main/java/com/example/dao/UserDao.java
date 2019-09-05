package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.models.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query("Select u from User u where u.technologies LIKE %:searchvalue% ")
	List<User> mentorsList(@Param("searchvalue") String searchvalue);

	public User findByid(int mentorid);
	
	 @Query("Select name from User where id =:mentorId")
	 public String getMentorName(@Param("mentorId") int mentorId);
	 
	 
}
