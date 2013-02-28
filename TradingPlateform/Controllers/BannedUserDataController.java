package com.fdm.Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fdm.DatabaseClasses.UserTableAccessor;
import com.fdm.UserDataClasses.BannedUserData;
import com.fdm.Users.User;

public class BannedUserDataController {
	private BannedUserData bannedUsersData;
	private UserTableAccessor bannedUserTableAccessor;
	private ResultSet bannedUsersSet;
	private final String tableName="Current_User_Data";
	
	public BannedUserDataController() throws SQLException
	{
		bannedUsersData= new BannedUserData();
		bannedUserTableAccessor= new UserTableAccessor(tableName);
	}

	public BannedUserData getBannedUsersData() {
		return bannedUsersData;
	}

	public void populateDataArray() throws SQLException
	{
		getData();
		storeData();
	}
	
	public void getData() throws SQLException
	{
		bannedUsersSet= bannedUserTableAccessor.select("username, passwrd, status, banned");
	}
	
	public void storeData() throws SQLException
	{
		User newUser;
		String ban;
		while(bannedUsersSet.next())
		{
			ban=bannedUsersSet.getString("banned");
			if(ban.equals("true"))
			{
				newUser= new User();
				newUser.setUsername(bannedUsersSet.getString("username"));
				newUser.setPassword(bannedUsersSet.getString("passwrd"));
				newUser.setStatus(bannedUsersSet.getString("status"));
				newUser.setBanned(Boolean.getBoolean(ban));
				bannedUsersData.addUser(newUser);
			}
		}
	}
}
