package com.accountant;

public class Accountant {
	private int id;
	private String name,password,email;
	long contactno;
	public Accountant() {
	}
	public Accountant(String name, String password, String email, long contactno) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.contactno = contactno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactno() {
		return contactno;
	}
	public void setContactno(long contactno) {
		this.contactno = contactno;
	}
}
