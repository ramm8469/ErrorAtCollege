package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.UserDAOImpl;
import com.project.model.User;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String fname ="";
	private String lname ="";
	private String uname ="";
	private String pass ="";
	private String utype = "";
	private String dob = "";
	Date dateOfBirth = null;
	// Creating the object of DAO Implementation class
	UserDAOImpl obj = new UserDAOImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 fname = request.getParameter("fname");
		 lname = request.getParameter("lname");
		 uname = request.getParameter("uname");
		 pass  = request.getParameter("password");
		 utype = request.getParameter("utype");
		 dob = request.getParameter("dob");
		 System.out.println(dob);
		 // SimleDateFormat class used to parse the string to date
		 SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		 
		 
		 try{
			 User user = new User();
			 
			 user.setFirstName(fname);
			 user.setLastName(lname);
			 user.setUserName(uname);
			 user.setPassword(pass);
			 user.setUserType(utype);
			
			 dateOfBirth = sd.parse(dob);
			 user.setDob(dateOfBirth);
			 
			 String res = obj.insert(user);
			 // Get The PrintWriter
			 PrintWriter out = response.getWriter();
			 out.print("Insertion Status : "+" "+res);
			 System.out.println(res);
			 
		 }catch(Exception e){
			 System.out.println("Error : "+e);
			 PrintWriter out = response.getWriter();
			 out.print("Insertion Status : Fail"+" Error : "+e);
		 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
