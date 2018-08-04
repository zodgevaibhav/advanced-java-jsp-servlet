package com.uiapi.busn.users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uiapi.commons.database.DBConnectionFactory;

public class LoginAuthentication {
	public static boolean isUserValid(String userName, String password)
	{
		System.out.println("********* in isValidUser : UserName - "+userName+" Password: "+password);
		String query = "select count(*)from users where user_id = ? and password=?";
		try {
			PreparedStatement stmt = DBConnectionFactory.getConnection().prepareStatement(query);
			stmt.setString(1, userName);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==1)
			{
				System.out.println("********* in isValidUser : record fetch count is 1.");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("********* in isValidUser : prepare statement failed.");
			e.printStackTrace();
		}
		System.out.println("********* in isValidUser : authentication failed.");
		return false;
	}
	
	public static boolean isUserNameAvailable(String userName)
	{
		System.out.println("********* in isUserNameAvailable : UserName - "+userName);
		String query = "select count(*)from users where user_id = ?";
		try {
			PreparedStatement stmt = DBConnectionFactory.getConnection().prepareStatement(query);
			stmt.setString(1, userName);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==1)
			{
				System.out.println("********* in isUserNameAvailable : record fetch count is 1.");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("********* in isUserNameAvailable : prepare statement failed.");
			e.printStackTrace();
		}
		System.out.println("********* in isUserNameAvailable : user name not found.");
		return true;
	}
}
