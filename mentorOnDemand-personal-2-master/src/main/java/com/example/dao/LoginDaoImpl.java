package com.example.dao;


import java.sql.*;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Login;



@Repository
public class LoginDaoImpl implements LoginDao{


	@Override
	public String isValidUser(String email, String password) throws ClassNotFoundException, SQLException {
		System.out.println("dao");
		Login login = new Login();
		 String userType;
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mentorondemand","root","root");
		PreparedStatement ps = conn.prepareStatement("select user_type from user where email = ? and password = ?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet resultSet = ps.executeQuery();
     
        if(resultSet.next())
        {
          userType = resultSet.getString("user_type");
          System.out.println(userType);
         return userType;
        }
        else
           return "null";
       }
		
	
public int obtainUserid(String email) throws ClassNotFoundException, SQLException {

	int id;
	Class.forName("com.mysql.jdbc.Driver");  
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mentorondemand","root","root");
	PreparedStatement ps = conn.prepareStatement("select id from user where email = ? ");
    ps.setString(1, email);
  
    ResultSet resultSet = ps.executeQuery();
 
    if(resultSet.next())
    {
      id = resultSet.getInt("id");
     return id;
    }
    else
       return 0;
   }
	
}
