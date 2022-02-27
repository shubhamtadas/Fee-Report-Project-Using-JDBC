package com.main;

import java.util.ArrayList;
import java.util.Scanner;
import com.admin.*;
import com.student.Student;
import com.accountant.*;
import com.student.*;

public class FeeReport {

public static void main(String[] args) {
	AccountantDao acntDaoObj = new AccountantDaoImpl();
	StudentDao stDaoObj = new StudentDaoImpl();
	System.out.println("Fee Report Management");
	while(true) {
		System.out.println("\n1. Admin Login \n2. Accountant Login \n3. Exit code");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice) {
		
		case 1:  // admin Login
			boolean flag1 = false;
			System.out.println("\nEnter Admin Name: ");
			String adminName = sc.next();
			System.out.println("\nEnter Password: ");
			String adminPass = sc.next();
			Admin admObj = new Admin();
			flag1 = admObj.adminLogin(adminName,adminPass);
			if(flag1) {
				System.out.println("\nLogin Successful..");
				
				boolean flag2 = false;
				do {
					System.out.println("\n-- Admin Section -- \n1. Add Accountant \n2. View Accountant \n3. Logout");
					int ch = sc.nextInt();
					
					switch(ch) {
					case 1:	//.. add accountant
						System.out.println("Accountant Name: ");
						String accName = sc.next();
						System.out.println("Password: ");
						String accPass = sc.next();
						System.out.println("Email: ");
						String accEmail = sc.next();
						System.out.println("Contact No: ");
						long accContact = sc.nextLong();
						
						Accountant accountant = new Accountant(accName,accPass,accEmail,accContact);
						boolean check = acntDaoObj.addAccountant(accountant);
						if(check) {
							 System.out.println("Accountant Record is inserted successfully !!!");
						}
						break;
							
					case 2: //.. view accountant
						ArrayList<String> al = acntDaoObj.viewAccountant();
						System.out.println(al);
						break;
							
					case 3: //.. logout
						flag2=true;
					}
				}while(flag2==false);
			}
			break; //.. end of case 1
			
		case 2:  // accountant login
			boolean flag2 = false;
			System.out.println("\nEnter Accountant Name: ");
			String accName = sc.next();
			System.out.println("\nEnter Password: ");
			String accPass = sc.next();
			flag1 = acntDaoObj.accountantLogin(accName,accPass);
			if(flag1) {
				System.out.println("Login Successful");
				boolean flag3 = false;
				do {
					System.out.println("\n-- Accountant Section -- \n1. Add Student  \n2. View Student \n3. Edit Student \n4. Due Fee \n5. Logout");
					int ch = sc.nextInt();
					
					switch(ch) {
					case 1:	//.. add student
						System.out.println("Student Name: ");
						String stName = sc.next();
						
						System.out.println("Email: ");
						String stEmail = sc.next();
						
						System.out.println("Course: ");
						String stCourse = sc.next();
						
						System.out.println("Fee: ");
						int stFee = sc.nextInt();
						
						System.out.println("Paid: ");
						int stPaid = sc.nextInt();
						
						int stDue = stFee-stPaid;
						
						System.out.println("Address: ");
						String stAddress = sc.next();
						
						System.out.println("City: ");
						String stCity = sc.next();
						
						System.out.println("State: ");
						String stState = sc.next();
						
						System.out.println("Country: ");
						String stCountry = sc.next();
						
						System.out.println("Contact No: ");
						String stContact = sc.next();
						
						Student student = new Student(stName, stEmail, stCourse, stFee, stPaid, stDue, stAddress, stCity, stState, stCountry, stContact);
						
						stDaoObj.addStudent(student);
						System.out.println("\nStudent added successfully !!");
						
						break;
							
					case 2: //.. view accountant
						ArrayList<String> al = stDaoObj.viewStudent();
						System.out.println(al);
						break;
							
					case 3: //.. logout
						flag3=true;
					}
				}while(flag3==false);
			}
			break; //.. end of case 2
		case 3:
			System.out.println("\nExit Code, Good Bye !!");
			System.exit(0);
		} // end of switch
		
		
	} // end of while

} //.. end of main method

} //.. end of FEE Report Class
