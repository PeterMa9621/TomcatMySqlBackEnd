package com.mjy.loginRegister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginImp {
	String DRIVER = "com.mysql.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306";
	String USER = "root";
	String PASSWORD = "mjy159357";
	String sql = "Select * from test.login where username = ? AND password = ?";
	
	int i = 0;
	public ArrayList<UserBeam> loginUser(UserBeam user) {
		// TODO Auto-generated method stub
		ArrayList<UserBeam> userList = new ArrayList<UserBeam>();
		
		String userName = user.getUserName();
		String password = user.getPassword();
		
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				UserBeam userBeam = new UserBeam();
				userBeam.setUserName(rs.getString("username"));
				userBeam.setPassword(rs.getString("password"));
				userList.add(userBeam);
				System.out.println("Userdata was got");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}

}
