package com.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.UserDAOImpl;
import com.project.model.User;

/**
 * Servlet implementation class LoginValidater
 */
@WebServlet("/LoginValidater")
public class LoginValidater extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Class Instances
	private String uname="";
	private String pass = "";

    public LoginValidater() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		uname = request.getParameter("uname");
		pass = request.getParameter("pass");
		
		// Create the user object with the login username and password
		User user = new User(uname,pass);
		// Create the DAO Impl object
		UserDAOImpl dao = new UserDAOImpl();

		Boolean flag = dao.isValid(user);
		RequestDispatcher rd = null;
		
	   if(flag){
		   String res = dao.getUserType(user.getUserName());
		   if(res.equals("a")){
			   rd = request.getRequestDispatcher("LoginModel/Admin.jsp");
			   request.setAttribute("msg", "Welcom admin : "+user.getUserName()+"");
			   
		   }
		   else if(res.equals("s") || res.equals("e")){
			   rd = request.getRequestDispatcher("/LoginModel/User.jsp");
			   request.setAttribute("user_msg", "Welcome user : "+user.getUserName()+"");
		   }
		   
		   // Forward the request dispatcher rd
		   rd.forward(request, response);
	   }
	   else{
		   rd = request.getRequestDispatcher("/LoginModel/Login.jsp");
		   request.setAttribute("login_msg", "UserName or PassWord is Invalid !");
		   rd.forward(request, response);
	   }
		System.out.println(uname+" : "+pass);
		
//		doGet(request, response);
	}

}
