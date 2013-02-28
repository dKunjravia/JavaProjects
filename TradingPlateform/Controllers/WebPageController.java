package com.fdm.Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fdm.Users.User;

public class WebPageController {
	private LoginController loginCheck;
	private DataController dataController;
	
	public WebPageController()
	{		
		try {
			dataController= new DataController();
			dataController.loadData();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getUserType(String choice,List inputs)
	{
		String pageInfo="";
		if(choice.equals("login"))
		{
			String username= inputs.remove(0).toString();
			String password= inputs.remove(0).toString();
			loginCheck= new LoginController();
			if( loginCheck.verifyLogin( username,password) )
			{
				pageInfo= dataController.getCurrentUserDataController().getCurrentUsersData().getUser(username).getStatus();
			}
			else
				pageInfo= "Invalid";
		}
		return pageInfo;
	}
	
	public boolean adminCommand(String choice, String username) throws SQLException
	{
		if(choice.equals("addUser"))
		{
			User newUser= dataController.getNewUserDataConroller().getNewUsersData().getUser(username);
			if(newUser != null)
			{
				dataController.getCurrentUserDataController().getCurrentUsersData().addUser(newUser);
				dataController.getCurrentUserDataController().addUserToDatabase(newUser);
				return true;
			}
		}
		if(choice.equals("deleteUser"))
		{
			dataController.getCurrentUserDataController().deleteUserFromDatabase(username);
		}
		return false;
	}
	
	public void closeConnection()
	{
		try {
			dataController.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
