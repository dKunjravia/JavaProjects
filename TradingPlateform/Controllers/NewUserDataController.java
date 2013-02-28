package com.fdm.Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fdm.DatabaseClasses.UserTableAccessor;
import com.fdm.UserDataClasses.NewUserData;
import com.fdm.Users.User;

public class NewUserDataController {
	private NewUserData newUsersData;
	private UserTableAccessor newUserTableAccessor;
	private ResultSet newUsersSet;
	private final String tableName="New_User_Data";
	
	public NewUserDataController() throws SQLException
	{
		newUsersData= new NewUserData();
		newUserTableAccessor= new UserTableAccessor(tableName);
	}

	public NewUserData getNewUsersData() {
		return newUsersData;
	}
	
	public void populateDataArray() throws SQLException
	{
		getData();
		storeData();
	}
	
	public void getData() throws SQLException
	{
		newUsersSet= newUserTableAccessor.select("username, passwrd, status, banned");
	}
	
	public void storeData() throws SQLException
	{
		User newUser;
		while(newUsersSet.next())
		{
			newUser= new User();
			newUser.setUsername(newUsersSet.getString("username"));
			newUser.setPassword(newUsersSet.getString("passwrd"));
			newUser.setStatus(newUsersSet.getString("status"));
			newUser.setBanned(Boolean.getBoolean(newUsersSet.getString("banned")));
			newUsersData.addUser(newUser);
		}
	}
}
