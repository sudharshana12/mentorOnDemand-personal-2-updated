package com.example.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.models.RequestTable;

public interface requestTableDao extends JpaRepository<RequestTable, Integer> {

	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("Update RequestTable SET status = 'Accepted' where userId = :studentId AND mentorid= :mentorid")
	void setAcceptStatus(@Param("studentId") int studentid,@Param("mentorid") int mentorid);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("Update RequestTable SET status = 'Rejected' where userId = :studentId AND mentorid= :mentorid")
	void setIgnoreStatus(@Param("studentId") int studentid,@Param("mentorid") int mentorid);
	
	
    @Query("Select status from RequestTable where userId =:userid")
    public boolean getStatus(@Param("userid") int userid);
    
    @Query("Select mentorid from RequestTable where userId =:userid")
    public List<Integer> getMentor(@Param("userid") int userid);
	
    @Query("Select status from RequestTable where userId =:userid AND mentorid =:mentorid")
    public String getStatus1(@Param("userid") int userid,@Param("mentorid") int mentorid);
    
    @Query("Select mentorid from RequestTable where user_id =:studentid")
	 public int getMentorid(@Param("studentid") int studentid);
    
    List<RequestTable> findByuserId(int userid);
}
