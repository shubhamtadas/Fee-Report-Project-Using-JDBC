package com.student;

import java.util.ArrayList;

public interface StudentDao {
	public boolean addStudent(Student student);
	public ArrayList<String> viewStudent();
	public ArrayList<Integer> dueFee(int roll);
	public boolean editStudent(int roll,Student student);
}
