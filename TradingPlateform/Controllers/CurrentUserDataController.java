package com.fdm.Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fdm.DatabaseClasses.UserTableAccessor;
import com.fdm.UserDataClasses.CurrentUserData;
import com.fdm.Users.User;

public class CurrentUserDataController {
	private CurrentUserData currentUsersData;
	private UserTableAccessor currentUserTableAccessor;
	private ResultSet currentUsersSet;
	private final String tableName="current_user_data";
	
	public CurrentUserDataController() throws SQLException
	{
		currentUsersData= new CurrentUserData();
		currentUserTableAccessor= new UserTableAccessor(tableName);
	}
	
	public CurrentUserData getCurrentUsersData() {
		return currentUsersData;
	}

	public void populateDataArray() throws SQLException
	{
		getData();
		storeData();
	}
	
	public void getData() throws SQLException
	{
		currentUsersSet= currentUserTableAccessor.select("username, passwrd, status, banned");
		currentUserTableAccessor.closeConnection();
	}
	
	public void storeData() throws SQLException
	{
		User newUser;
		while(currentUsersSet.next())
		{
			if(currentUsersSet.getString("banned").equals("false"))
			{
				newUser= new User();
				newUser.setUsername(currentUsersSet.getString("username"));
				newUser.setPassword(currentUsersSet.getString("passwrd"));
				newUser.setStatus(currentUsersSet.getString("status"));
				newUser.setBanned(Boolean.getBoolean(currentUsersSet.getString("banned")));
				currentUsersData.addUser(newUser);
			}
		}
	}
	
	public void addUserToDatabase(User user) throws SQLException
	{
		currentUserTableAccessor.insert(user.getUsername(), user.getPassword(),
										user.getStatus(), Boolean.toString(user.isBanned()));
	}
	
	public void deleteUserFromDatabase(String username) throws SQLException
	{
		currentUserTableAccessor.delete("username", username);
	}
}
