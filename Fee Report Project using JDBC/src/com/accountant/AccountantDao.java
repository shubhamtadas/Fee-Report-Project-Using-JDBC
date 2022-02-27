package com.accountant;

import java.util.ArrayList;

public interface AccountantDao {
	public boolean accountantLogin(String acc_name, String acc_password);
	public boolean addAccountant(Accountant accountant);
	public ArrayList<String> viewAccountant();
	
}
