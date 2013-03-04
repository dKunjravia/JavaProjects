package com.fdm.Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.fdm.UserDataClasses.CurrentUserData;
import com.fdm.Users.User;
import com.fdm.views.LoginView;
import com.fdm.views.RegisterView;
import com.fdm.views.StartingView;
import com.fdm.views.SystemAdminView;

public class mainController{
	private DataController dataController;
	//Constant value for user choices
	private final int LOGIN=1;
	private final int REGISTER=2;
	private final int QUIT=3;
	private final int LOGOFF=5;
	
	public mainController() throws FileNotFoundException, IOException, SQLException
	{
		dataController= new DataController();
	}
		
	public void start() throws SQLException
	{
		dataController.loadData();
		startView();
	}
	
	public void startView()
	{
		StartingView startingView= new StartingView();
		int choice=startingView.getChoice();
		while(choice != QUIT)
		{
			if (choice == LOGIN)
				login();
			else if(choice == REGISTER)
				register();
			else
				startingView.invalidChoice();
			choice=startingView.getChoice();
		}
	}
	
	public void login()
	{
		LoginView loginObject= new LoginView();
		loginObject.getUserInput();
		LoginController loginCheck= new LoginController();
		if(loginCheck.verifyLogin( loginObject.getUsername(),
								   loginObject.getPassword()))
		{
			loginObject.loginSuccess();
			userView(loginObject.getUsername());
		}
		else
			loginObject.loginFailed();
	}
	
	public void userView(String username)
	{
		CurrentUserData currentUserData= new CurrentUserData();
		User currentUser= currentUserData.getUser(username);
		if(currentUser.getStatus().equals("Admin"))
		{
			adminView(currentUser);
		}
	}
	
	public void adminView(User admin)
	{
		SystemAdminView adminView= new SystemAdminView();
		while(adminView.getChoice() != LOGOFF)
		{
			adminView.startingPage();
			SystemAdminController adminController= new SystemAdminController(adminView, admin);
			adminController.performAction();
		}
	}
	
	public void register()
	{
		RegisterView registerViewObject= new RegisterView();
		RegisterController registerControllerObject= new RegisterController();
		registerViewObject.getUserInput();
		registerControllerObject.createUser(registerViewObject);
		if(registerControllerObject.addUserToData())
			registerViewObject.registrationSuccess();
		else
			registerViewObject.registrationFailed();
	}
}
