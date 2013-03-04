package com.fdm.RequestDataClasses;

import java.util.ArrayList;

import com.fdm.RequestsManagement.Requests;

public class RequestData {
	private ArrayList<Requests> requestDatabase= new ArrayList<Requests>();
	private static RequestData instance;
	
	private RequestData()
	{
	}
	public static RequestData getInstance()
	{
		if(instance == null)
			instance= new RequestData();
		return instance;
	}
	
	public Requests getRequest(int index)
	{
		return requestDatabase.get(index);
	}
	
	public void addRequest(Requests request)
	{
		requestDatabase.add(request);
	}
	
	public boolean requestExists(Requests request)
	{
		for(Requests currentRequest : requestDatabase)
		{
			if(currentRequest.equals(request))
				return true;
		}
		return false;
	}
	
	public void replaceRequest(int index,Requests request)
	{
		requestDatabase.set(index, request);
	}
	
	public void clearRequestdata()
	{		
		requestDatabase.clear();
	}
	
	public int getLength()
	{
		return requestDatabase.size();
	}
}
