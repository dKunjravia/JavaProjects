package com.fdm.UserDataClasses;

import java.util.ArrayList;

import com.fdm.Users.User;

public class NewUserData implements UserData {
	
	private static ArrayList<User> userData=new ArrayList<User>();
	
	public User getUser(String username)
	{
		return userData.get(getUserIndex(username));
	}
	
	public ArrayList<User> getUserData() {
		return userData;
	}

	public void addUser(User user)
	{
		if(!userExists(user.getUsername()))
			userData.add(user);
	}
	
	public void clearUserdata()
	{		
			userData.clear();
	}
	
	public int getLength()
	{
		return userData.size();
	}
	
	public boolean userExists(String username)
	{
		for(User currentUser : userData)
		{
			if(currentUser.getUsername().equals(username))
				return true;
		}
		return false;
	}

	public boolean deleteUser(String username) {
		for(User currentUser : userData)
		{
			if(currentUser.getUsername().equals(username))
			{
				userData.remove(currentUser);
				return true;
			}
		}
		return false;
	}
	
	protected int getUserIndex(String username)
	{
		int index=-1;
		if(!userData.isEmpty())
		{
			for(User currentUser : userData)
			{
				index++;
				if(currentUser.getUsername().equals(username))
					return index;
			}
		}
		return index;
	}

}
