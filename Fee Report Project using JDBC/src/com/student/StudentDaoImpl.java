package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.connectionProvider.CP;

public class StudentDaoImpl implements StudentDao{

    Connection con = null;
	@Override
	public boolean addStudent(Student student) {
	    PreparedStatement pstmt = null;
	    boolean flag=false;
	    String query = "INSERT INTO student(st_name, st_email, st_course, st_fee, st_paid, st_due, st_address, st_city, st_state, st_country, st_contact)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	    try {
  	   	  
	    	Connection con = CP.createC(); // from CP class
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, student.getName());
	         pstmt.setString(2, student.getEmail());
	         pstmt.setString(3, student.getCourse());
	         pstmt.setInt(4, student.getFee());
	         pstmt.setInt(5, student.getPaid());
	         pstmt.setInt(6, student.getDue());
	         pstmt.setString(7, student.getAddress());
	         pstmt.setString(8, student.getCity());
	         pstmt.setString(9, student.getState());
	         pstmt.setString(10, student.getCountry());
	         pstmt.setString(11, student.getContact());
	         
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
	public ArrayList<String> viewStudent() {
		ArrayList <String> accData = new ArrayList<String>();
		int no_of_column=12;
		try {
			Connection con = CP.createC();
			Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			String q= "select * from student";
			
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
	}
	@Override
	public ArrayList<Integer> dueFee(int roll) {
		ArrayList <Integer> dueData = new ArrayList<Integer>();
		try {
			Connection con = CP.createC();
			Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			String q= "select st_roll,st_due from student";
			ResultSet rs=smt.executeQuery(q);
			if(rs.next()){ 
				
				do {
					if(rs.getInt(1) == roll) {
						dueData.add(rs.getInt(2));
					}
				}while(rs.next());
			}
			con.close();
		} //.. end of try
		catch (Exception e) {
			e.printStackTrace();
		}//.. end of catch
		return(dueData);
	}
	@Override
	public boolean editStudent(int roll,Student student) {
		boolean flag=false;
		PreparedStatement pstmt = null;

		String q= "update student set  st_name=?,st_email=?,st_course=?,st_fee=?,st_paid=?,st_due=?,st_address=?,st_city=?,st_state=?,st_country=?,st_contact=? where st_roll=?";
		 try {
			 Connection con = CP.createC();
	         pstmt = con.prepareStatement(q);
	         pstmt.setString(1, student.getName());
	         pstmt.setString(2, student.getEmail());
	         pstmt.setString(3, student.getCourse());
	         pstmt.setInt(4, student.getFee());
	         pstmt.setInt(5, student.getPaid());
	         pstmt.setInt(6, student.getDue());
	         pstmt.setString(7, student.getAddress());
	         pstmt.setString(8, student.getCity());
	         pstmt.setString(9, student.getState());
	         pstmt.setString(10, student.getCountry());
	         pstmt.setString(11, student.getContact());
	         pstmt.setInt(12, roll);
	      
	         int status = pstmt.executeUpdate();
	         if(status > 0) {
	           flag = true;
	         }
	      } catch(Exception e){
	         e.printStackTrace();
	      }
		return(flag);
	}

}
