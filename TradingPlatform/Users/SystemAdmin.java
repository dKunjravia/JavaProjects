package com.fdm.Users;

import com.fdm.UserDataClasses.BannedUserData;
import com.fdm.UserDataClasses.CurrentUserData;

public class SystemAdmin extends User {
	private CurrentUserData currentUserData= new CurrentUserData();
	private BannedUserData bannedUserData= new BannedUserData();
	public void addUser(User user)
	{
		currentUserData.addUser(user);
	}
	
	public void deleteUser(String username)
	{
		currentUserData.deleteUser(username);
	}
	
	public void banUser(String username)
	{		
		User userCopy= currentUserData.getUser(username);
		currentUserData.deleteUser(username);
		userCopy.setBanned(true);
		bannedUserData.addUser(userCopy);
	}
	
	public void changeUserPermission(String username)
	{
		currentUserData.getUser(username).setStatus("Admin");
	}
}
