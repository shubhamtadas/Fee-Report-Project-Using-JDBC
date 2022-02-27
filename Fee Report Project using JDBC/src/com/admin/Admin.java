package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin {
	static String JdbcURL = "jdbc:mysql://localhost:3306/feereport";
	static String Username = "root";
	static String password = "root";
	static Connection con = null;
	boolean flag = false;
	public boolean adminLogin(String admName, String admPassword) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JdbcURL, Username, password);
			Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			String q="SELECT adm_name,adm_pass from admin";
			
			ResultSet rs=smt.executeQuery(q);
		
			if(rs.next()){
				if(rs.getString(1).equals(admName) && rs.getString(2).equals(admPassword)) {
					flag = true;
				}
				else {
					System.out.println("Incorrect Credentials..");
				}
			} 
			else{
				System.out.println("Record Not Found...");
			}
			con.close();
			
		} // end of try
		catch (Exception e) {
			e.printStackTrace();
		} // end of catch
		return(flag);
	}
}
