package com.uiapi.commons.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionFactory {
	private static String dbUrl = "jdbc:mysql://localhost:3306/advancedjava";

	private static String userName = "root";
	private static String password = "root";

	private static Connection conn;

	public static Connection getConnection() {
		if (null == conn) {
			try {

				System.out.println("********** in getConnection : connection is not yet created, creating first time.");
				// ********************** Register driver with DriverManager ******************
				Class.forName("com.mysql.jdbc.Driver");

				// System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");

				// java -Djdbc.drivers=com.mysql.jdbc.Driver <<<ClassFileName>>>

				// *******************************************************************************
				System.out.println("********** in getConnection: Connection driver ...");
				conn = DriverManager.getConnection(dbUrl, userName, password);
				return conn;
			} catch (Exception e) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Unable to create connection \n\n\n");
				e.printStackTrace();
			}
		}	
		System.out.println("********** in getConnection : connection is already exists, rending it back.");
		return conn;
	}
}
