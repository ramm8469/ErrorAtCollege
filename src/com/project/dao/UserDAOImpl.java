package com.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.project.dbutil.MyConnection;
import com.project.model.User;

public class UserDAOImpl implements UserDAO {
	private Connection conn = new MyConnection().getConnection();

	public String insert(User user) {
		String res = "FAIL";
		String sql = "INSERT INTO user(fname,lname,userName,passWord,userType,dob) VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			// Statement Creation
			ps = conn.prepareStatement(sql);
			// Set The parameter value7
			ps.setString(1, user.getFirstName());
			ps.setString(2,user.getLastName());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getUserType());
			ps.setDate(6, new java.sql.Date(user.getDob().getTime()));
			// Execute the statement
			int r = ps.executeUpdate();
			if (r > 0) {
				res = "SUCCESS";
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return res;
	}

	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		String query = "select * from user";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			// Create the statement
			stmt = conn.createStatement();
			
			// Execute the statement
			rs = stmt.executeQuery(query);
			
			//process the result
			while(rs.next()){
				
				// Read the Data from the DataBase
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String uname = rs.getString("userName");
				java.util.Date dob = rs.getDate("dob");
				
				
				User u = new User(fname,lname,uname,dob);
				// Add the student to the student list
				list.add(u);
			}
			
		}catch(Exception e){
			System.out.println("Error : \n"+e);
		}
		System.out.println("READING");
		
		return list;
	}

	
	@Override
	public String update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid(User user) {
		Boolean flag = false;
		String uname = user.getUserName();
		String pass = user .getPassword();
		String db_uname = "";
		String db_pass = "";
		
		String query ="select userName,passWord from user where userName = \""+uname+"\";";
		
		// Create Statement object
		try {
			Statement stmt = conn.createStatement();
			ResultSet rt = stmt.executeQuery(query);
			
			while(rt.next()){
				db_uname = rt.getString("userName");
				db_pass = rt.getString("passWord");
			}
			
			if(uname.equals(db_uname) && pass.equals(db_pass)){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		
		return flag;
	
	}

	@Override
	public String getUserType(String username) {
		String query ="select userType from user where userName = \""+username+"\"";
		String userType ="";
		String sendUserType ="";
		// Creat statemetn object
		try{
			Statement stmt = conn.createStatement();
			ResultSet rt = stmt.executeQuery(query);
			
			while(rt.next()){
				userType = rt.getString("userType");
				if(userType == null){
					sendUserType = "s";
				}
			}
		}catch (Exception e){
			System.out.println(e);
		}
		return sendUserType;
	}
	
	

}
