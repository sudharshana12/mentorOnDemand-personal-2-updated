package com.example.dao;

import java.sql.SQLException;

public interface LoginDao {
	String isValidUser(String email, String password) throws ClassNotFoundException, SQLException;
	public int obtainUserid(String email) throws ClassNotFoundException, SQLException;
}
