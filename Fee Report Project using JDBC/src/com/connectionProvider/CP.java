package com.connectionProvider;
import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	static Connection con;
	
	public static Connection createC() {
		try {
			// load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//creating conncetion
			String url = "jdbc:mysql://localhost:3306/feereport";
			String user = "root";
			String password = "root";
			
			con = DriverManager.getConnection(url,user,password);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}

