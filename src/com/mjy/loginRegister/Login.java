package com.mjy.loginRegister;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3098523793052484521L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		//username and password set in UserBeam
		
		UserBeam user = new UserBeam();
		user.setUserName(userName);
		user.setPassword(password);
		
		LoginImp rimp = new LoginImp();
		ArrayList<UserBeam> userList = rimp.loginUser(user);
		System.out.println("Size: " + userList.size());
		for(UserBeam userBeam : userList) {
			if(userBeam.getUserName().equals(userName) && userBeam.getPassword().equals(password)) {
				JSONArray array = new JSONArray(userList);
				
				PrintWriter pw = resp.getWriter();
				pw.write(array.toString());
				
				System.out.println("JSONArray data " + array.toString());
			}
		}
	}
}
