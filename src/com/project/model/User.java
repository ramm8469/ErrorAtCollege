package com.project.model;

import java.util.Date;

public class User {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String UserType;
	private Date dob;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String lastName, String userName, String password,String UserType,Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.UserType = UserType;
		this.dob  = dob;
	}

	public User(String firstName, String lastName, String userName, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.dob = dob;
	}
	
	

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}
