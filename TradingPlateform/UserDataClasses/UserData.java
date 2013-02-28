package com.fdm.UserDataClasses;

import com.fdm.Users.User;

public interface UserData {
	
	public User getUser(String username);
	
	public void addUser(User user);
	
	public boolean deleteUser(String username);
		
	public void clearUserdata();
	
	public int getLength();
	
	public boolean userExists(String username);
}
