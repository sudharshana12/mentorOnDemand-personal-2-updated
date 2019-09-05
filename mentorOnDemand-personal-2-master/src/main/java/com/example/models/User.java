package com.example.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class User {
  
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;

  private String password;

  private String email;

  private String mobileno;
  private String userType;
  
  private String timezone;
  
  private String technologies;
 
  private String facilities;
  
  private String linkedin_URL;
 
  private int exp;
  private float rating;
  private int numberOfTrainings;
  private Date available_date;
  
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobileno() {
	return mobileno;
}
public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public String getTimezone() {
	return timezone;
}
public void setTimezone(String timezone) {
	this.timezone = timezone;
}
public String getTechnologies() {
	return technologies;
}
public void setTechnologies(String technologies) {
	this.technologies = technologies;
}
public String getFacilities() {
	return facilities;
}
public void setFacilities(String facilities) {
	this.facilities = facilities;
}
public String getLinkedin_URL() {
	return linkedin_URL;
}
public void setLinkedin_URL(String linkedin_URL) {
	this.linkedin_URL = linkedin_URL;
}
public int getExp() {
	return exp;
}
public void setExp(int exp) {
	this.exp = exp;
}
public float getRating() {
	return rating;
}
public void setRating(float rating) {
	this.rating = rating;
}
public int getNumberOfTrainings() {
	return numberOfTrainings;
}
public void setNumberOfTrainings(int numberOfTrainings) {
	this.numberOfTrainings = numberOfTrainings;
}
public Date getAvailable_date() {
	return available_date;
}
public void setAvailable_date(Date available_date) {
	this.available_date = available_date;
}
  
	
	
	
	
}
