package com.springs.security.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		try
		{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr";
		String password = "hr";

		// Load the Connector/J driver
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		// Establish connection to MySQL
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("Connected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
