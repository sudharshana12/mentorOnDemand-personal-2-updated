package com.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestTable {
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 int reqId;
	int userId;
	int mentorid;
	String status;
	String mentorName;
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMentorid() {
		return mentorid;
	}
	public void setMentorid(int mentorid) {
		this.mentorid = mentorid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	
}
