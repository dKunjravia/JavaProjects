package com.fdm.Controllers;

import com.fdm.UserDataClasses.NewUserData;
import com.fdm.Users.SystemAdmin;
import com.fdm.Users.User;
import com.fdm.views.SystemAdminView;

public class SystemAdminController {
	private SystemAdminView adminView;
	private SystemAdmin admin=new SystemAdmin();
	
	public SystemAdminController(SystemAdminView adminView,User admin)
	{
		this.adminView= adminView;
		this.admin.setUsername(admin.getUsername());
		this.admin.setPassword(admin.getPassword());
		this.admin.setStatus(admin.getStatus());
		this.admin.setBanned(admin.isBanned());
	}
	
	private User getUser(String username)
	{
		NewUserData userData= new NewUserData();
		return userData.getUser(username);
		
	}
	
	private boolean addUser(String username)
	{
		User user= getUser(username);
		if(user != null)
		{
			admin.addUser(user);
			return true;
		}
		else
			adminView.invalidChoice();
		return false;
	}
	public void performAction()
	{
		String username;
		switch(adminView.getChoice())
		{
			case 1:
					adminView.showNewUserRequests();
					username= adminView.getUsername();
					addUser(username);
					break;
			case 2:
					username= adminView.getUsername();
					admin.deleteUser(username);
					break;
			case 3:
					username= adminView.getUsername();
					admin.banUser(username);
					break;
			case 4:
					username= adminView.getUsername();
					admin.changeUserPermission(username);
					break;
		}
	}
}
