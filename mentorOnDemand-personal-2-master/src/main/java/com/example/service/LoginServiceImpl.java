package com.example.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LoginDao;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginDao logindao;

	@Override
	public String isValidUser(String email, String password) throws ClassNotFoundException, SQLException {

		return logindao.isValidUser(email, password);
	}

	@Override
	public int obtainUserid(String email) throws ClassNotFoundException, SQLException {
		return logindao.obtainUserid(email);
	}

}
