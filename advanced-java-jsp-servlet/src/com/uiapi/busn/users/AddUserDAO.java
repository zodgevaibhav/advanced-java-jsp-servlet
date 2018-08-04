package com.uiapi.busn.users;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.uiapi.commons.database.DBConnectionFactory;

public class AddUserDAO {
	
	public static boolean addUser(String firstName, String lastName, String userName, String password)
	{
		String query = "insert into users values (?,?,?,?)";
			PreparedStatement stmt;
			
			try {
				stmt = DBConnectionFactory.getConnection().prepareStatement(query);
				stmt.setString(1, firstName);
				stmt.setString(2, lastName);
				stmt.setString(3, userName);
				stmt.setString(4, password);
				if(!stmt.execute())
					return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		return false;
	}
}
