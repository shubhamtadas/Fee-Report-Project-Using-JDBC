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
						Accountant accountant = new Accountant();
						System.out.println("Accountant Name: ");
						accountant.setName(sc.next());
						
						System.out.println("Password: ");
						accountant.setPassword(sc.next());
						
						System.out.println("Email: ");
						accountant.setEmail(sc.next());
						
						System.out.println("Contact No: ");
						accountant.setContactno(sc.nextLong());
			
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
						Student student = new Student();
						System.out.println("Student Name: ");
						student.setName(sc.next());
						
						System.out.println("Email: ");
						student.setEmail(sc.next());
						
						System.out.println("Course: ");
						student.setCourse(sc.next());
						
						System.out.println("Fee: ");
						student.setFee(sc.nextInt());
						
						System.out.println("Paid: ");
						student.setPaid(sc.nextInt());
						
						System.out.println("Due: ");
						student.setDue(sc.nextInt());
						
						System.out.println("Address: ");
						student.setAddress(sc.next());
						
						System.out.println("City: ");
						student.setCity(sc.next());
						
						System.out.println("State: ");
						student.setState(sc.next());
						
						System.out.println("Country: ");
						student.setCountry(sc.next());
						
						System.out.println("Contact No: ");
						student.setContact(sc.next());
						
						boolean ch1 = stDaoObj.addStudent(student);
						if(ch1) {
							System.out.println("\nStudent added successfully !!");
						}
						break;
							
					case 2: //.. view accountant
						ArrayList<String> al = stDaoObj.viewStudent();
						System.out.println(al);
						break;
					case 3:	//.. edit student
						Student student1 = new Student();
						System.out.println("\nEnter Roll no: ");
						int rollNo = sc.nextInt();
						
						System.out.println("Student Name: ");
						student1.setName(sc.next());
						
						System.out.println("Email: ");
						student1.setEmail(sc.next());
						
						System.out.println("Course: ");
						student1.setCourse(sc.next());
						
						System.out.println("Fee: ");
						student1.setFee(sc.nextInt());
						
						System.out.println("Paid: ");
						student1.setPaid(sc.nextInt());
						
						System.out.println("Due: ");
						student1.setDue(sc.nextInt());
						
						System.out.println("Address: ");
						student1.setAddress(sc.next());
						
						System.out.println("City: ");
						student1.setCity(sc.next());
						
						System.out.println("State: ");
						student1.setState(sc.next());
						
						System.out.println("Country: ");
						student1.setCountry(sc.next());
						
						System.out.println("Contact No: ");
						student1.setContact(sc.next());
						
//						Student student1 = new Student(stName1, stEmail1, stCourse1, stFee1, stPaid1, stDue1, stAddress1, stCity1, stState1, stCountry1, stContact1);
						boolean check = stDaoObj.editStudent(rollNo,student1);
						if(check) {
							System.out.println("Student Updated Successfully");
						}
						break;
					case 4: //.. due fee
						System.out.println("\nEnter Roll no: ");
						int rollNo1 = sc.nextInt();
						ArrayList<Integer> al1 = stDaoObj.dueFee(rollNo1);
						System.out.println("Due Fees: "+al1);
						break;
					case 5: //.. logout
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
