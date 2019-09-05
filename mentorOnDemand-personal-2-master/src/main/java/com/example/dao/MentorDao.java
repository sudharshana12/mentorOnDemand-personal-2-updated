package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.models.User;

public interface MentorDao extends JpaRepository<User, Integer>{

	@Query("Select userId from RequestTable where mentorid = :mentorid ")
	List<Integer> studentList(@Param("mentorid") int mentorid);
	
	@Query("Select name from User where id = :userid")
	String studentName(@Param("userid") Integer userid);
	
	@Query("Select id from User where name = :studentName")
	int StudentId(@Param("studentName") String studentName);

}
