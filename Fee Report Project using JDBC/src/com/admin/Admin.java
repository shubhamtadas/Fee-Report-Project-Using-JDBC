package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.connectionProvider.CP;

public class Admin {

	boolean flag = false;
	public boolean adminLogin(String admName, String admPassword) {
		try {
			Connection con = CP.createC(); // from CP class
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
