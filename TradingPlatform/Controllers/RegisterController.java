package com.fdm.Controllers;

import com.fdm.RequestDataClasses.RequestData;
import com.fdm.RequestsManagement.Requests;
import com.fdm.UserDataClasses.CurrentUserData;
import com.fdm.UserDataClasses.NewUserData;
import com.fdm.UserDataClasses.UserData;
import com.fdm.Users.Shareholder;
import com.fdm.Users.User;
import com.fdm.views.RegisterView;

public class RegisterController {
	private RequestData requestData= RequestData.getInstance();

	private UserData currentUserData=new CurrentUserData();
	private UserData newUserData=new NewUserData();
	private User newUser;
	
	public void createUser(RegisterView registerViewObject)
	{
		newUser= new Shareholder();
		newUser.setUsername(registerViewObject.getUsername());
		newUser.setPassword(registerViewObject.getPassword());
		newUser.setStatus(registerViewObject.getStatus());
	}
	
	public boolean addUserToData()
	{
		boolean userFound= currentUserData.userExists(newUser.getUsername());
		if(!userFound)
		{
			newUserData.addUser(newUser);
			addRequestToData();
		}
		return !userFound;
	}
	
	public void addRequestToData()
	{
		Requests newRequest= new Requests();
		newRequest.setUsername(newUser.getUsername());
		newRequest.setRequestText("Register");
		newRequest.setStatus("Outstanding");
		requestData.addRequest(newRequest);
	}
}
