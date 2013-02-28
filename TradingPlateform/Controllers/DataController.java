package com.fdm.Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.fdm.DatabaseClasses.DatabaseConnection;


public class DataController {
	private DatabaseConnection newConnection;
	private CurrentUserDataController currentUserDataController;
	private NewUserDataController newUserDataConroller;
	private BannedUserDataController bannedUserDataController;
	private RequestDataController requestDataController;
	
	public CurrentUserDataController getCurrentUserDataController() {
		return currentUserDataController;
	}

	public NewUserDataController getNewUserDataConroller() {
		return newUserDataConroller;
	}

	public BannedUserDataController getBannedUserDataController() {
		return bannedUserDataController;
	}

	public RequestDataController getRequestDataController() {
		return requestDataController;
	}
	
	public DataController() throws FileNotFoundException, IOException, SQLException
	{
		currentUserDataController= new CurrentUserDataController();
		newUserDataConroller= new NewUserDataController();
		bannedUserDataController= new BannedUserDataController();
		requestDataController= new RequestDataController();
	}
	
	public void loadData() throws SQLException
	{
		currentUserDataController.populateDataArray();
		newUserDataConroller.populateDataArray();
		bannedUserDataController.populateDataArray();
		requestDataController.populateDataArray();
		newConnection.closeConnection();
	}
	
	public void closeConnection() throws SQLException
	{
		newConnection.closeConnection();
	}
}
