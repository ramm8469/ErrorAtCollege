package com.project.dao;

import java.util.List;

import com.project.model.User;

public interface UserDAO {

	/*
	 * Return SUCCESS or FAIL on insert 
	 * to database table
	 */
	public String insert(User user);
	public String update(User user);
	public String delete(User user);
	public List<User> getAll();
	
	//Login validation method
	public boolean isValid(User user);
	public String getUserType(String username);
	
}
