package com.fdm.Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fdm.DatabaseClasses.RequestTableAccessor;
import com.fdm.RequestDataClasses.RequestData;
import com.fdm.RequestsManagement.Requests;

public class RequestDataController {
	private RequestData requestData;
	private RequestTableAccessor requestTableAccessor;
	private ResultSet requestsSet;
	private final String tableName="Request_Data";
	
	public RequestDataController() throws SQLException
	{
		requestData= RequestData.getInstance();
		requestTableAccessor= new RequestTableAccessor(tableName);
	}
	
	public RequestData getRequestData()
	{
		return requestData;
	}
	
	public void populateDataArray() throws SQLException
	{
		getData();
		storeData();
	}
	
	public void getData() throws SQLException
	{
		requestsSet= requestTableAccessor.select("requestText, status, username, adminName");
	}
	
	public void storeData() throws SQLException
	{
		Requests newRequest;
		while(requestsSet.next())
		{
				newRequest= new Requests();
				newRequest.setRequestText(requestsSet.getString("requestText"));
				newRequest.setStatus(requestsSet.getString("status"));
				newRequest.setUsername(requestsSet.getString("username"));
				newRequest.setAdminName(requestsSet.getString("adminName"));
				requestData.addRequest(newRequest);
		}
	}
}
