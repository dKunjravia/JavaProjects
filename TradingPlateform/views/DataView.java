package com.fdm.views;

import com.fdm.Controllers.BannedUserDataController;
import com.fdm.Controllers.CurrentUserDataController;
import com.fdm.Controllers.NewUserDataController;
import com.fdm.Controllers.RequestDataController;
import com.fdm.Users.User;

public class DataView {
	public static void viewRequests(RequestDataController requestDataController)
	{
		int index;
		System.out.println("\nPending Requests");
		for(index= 0; index< requestDataController.getRequestData().getLength(); index++)
		{
			System.out.println( requestDataController.getRequestData().getRequest(index).getUsername() + 
						"\t" +	requestDataController.getRequestData().getRequest(index).getRequestText() +
						"\t" +	requestDataController.getRequestData().getRequest(index).getStatus() +
						"\t" +	requestDataController.getRequestData().getRequest(index).getAdminName());
		}
	}
	
	public static void viewCurrentUsers(CurrentUserDataController currentUserDataController)
	{
		System.out.println("\nCurrent Users");
		for(User user: currentUserDataController.getCurrentUsersData().getUserData())
		{
			System.out.println( user.getUsername() + 
						"\t" +	user.getPassword() +
						"\t" +	user.getStatus() +
						"\t" +	user.isBanned());
		}
	}
	
	public static void viewNewUsers(NewUserDataController newUserDataConroller)
	{
		System.out.println("\nNew Users");
		for(User user: newUserDataConroller.getNewUsersData().getUserData())
		{
			System.out.println( user.getUsername() + 
						"\t" +	user.getPassword() +
						"\t" +	user.getStatus() +
						"\t" +	user.isBanned());
		}
	}
	
	public static void viewBanUsers(BannedUserDataController bannedUserDataController)
	{
		System.out.println("\nBan Users");
		for(User user: bannedUserDataController.getBannedUsersData().getUserData())
		{
			System.out.println( user.getUsername() + 
						"\t" +	user.getPassword() +
						"\t" +	user.getStatus() +
						"\t" +	user.isBanned());
		}
	}
}
