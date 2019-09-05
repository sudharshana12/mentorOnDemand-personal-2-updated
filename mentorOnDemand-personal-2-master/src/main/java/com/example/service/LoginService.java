package com.example.service;

import java.sql.SQLException;

public interface LoginService {

	public String isValidUser(String email, String password) throws ClassNotFoundException, SQLException;
	public int obtainUserid(String email) throws ClassNotFoundException, SQLException;

}
