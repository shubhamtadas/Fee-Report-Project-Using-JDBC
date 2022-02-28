package com.accountant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.connectionProvider.CP;

public class AccountantDaoImpl implements AccountantDao {

    Connection con = null;
    @Override
	public boolean accountantLogin(String acc_name, String acc_password) {
    	boolean flag = false;
    	try {
    		Connection con = CP.createC(); // from CP class
			Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			String q="SELECT acc_name,acc_pass from accountant";
			
			ResultSet rs=smt.executeQuery(q);
		
			while(rs.next()){
				if(rs.getString(1).equals(acc_name) && rs.getString(2).equals(acc_password)) {
					flag = true;
				}
			}
			con.close();
			
		} // end of try
		catch (Exception e) {
			e.printStackTrace();
		} // end of catch
		return(flag);
	}
	@Override
	public boolean addAccountant(Accountant accountant) {
	    PreparedStatement pstmt = null;
	    boolean flag=false;
	    String query = "INSERT INTO accountant(acc_name,acc_pass,acc_email,acc_contact)" + "VALUES (?,?,?,?)";
	    try {
  	   	  
	    	Connection con = CP.createC();
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, accountant.getName());
	         pstmt.setString(2, accountant.getPassword());
	         pstmt.setString(3, accountant.getEmail());
	         pstmt.setDouble(4, accountant.getContactno());
	         
	         int status = pstmt.executeUpdate();
	         if(status > 0) {
	           flag = true;
	         }
	      } catch(Exception e){
	         e.printStackTrace();
	      }
	    return flag;
	}
	@Override
	public ArrayList<String> viewAccountant() {
		ArrayList <String> accData = new ArrayList<String>();
		int no_of_column=5;
		try {
			Connection con = CP.createC();
			Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			String q= "select * from accountant";
			
			ResultSet rs=smt.executeQuery(q);
			if(rs.next()){ 
				
				do {
					int i=1;
					while(i<=no_of_column) {
						accData.add(rs.getString(i));
						i++;
					}
					accData.add("\n");
				}while(rs.next());
			}
			con.close();
		} //.. end of try
		catch (Exception e) {
			e.printStackTrace();
		}//.. end of catch
		return(accData);
			
	} //.. end of viewAccountant 
	
} //..  end of AccountantDaoImpl
	
