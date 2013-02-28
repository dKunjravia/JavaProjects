
package com.fdm.Controllers;

import com.fdm.UserDataClasses.CurrentUserData;
import com.fdm.Users.User;

public class LoginController {
	private CurrentUserData currentUsers=new CurrentUserData();
	
	public boolean verifyLogin(String username, String password)
	{
		String testUsername, testPassword;
		for(User user: currentUsers.getUserData())
		{
			testUsername= user.getUsername();
			testPassword= user.getPassword();
			if(username.equals(testUsername) && password.equals(testPassword))
				return true;
		}
		return false;
	}
	
	public void addLog(String username, String activity)
	{
		
	}
}
