package com.kk.onlinestore.service;

import java.util.HashMap;
import java.util.Map;

public class LoginService {
	
	private Map<String, String> usersDB = new HashMap<String, String>();
	
	public LoginService() {
		usersDB.put("admin", "admin");
		usersDB.put("krishna", "krishna");
		usersDB.put("java", "java");
	}

	public boolean authenticate(String username, String password) {
		
		if(usersDB.get(username)!=null && usersDB.get(username).equalsIgnoreCase(password)){
			return true;
		}
		return false;
	}
}
