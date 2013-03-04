package com.fdm.RequestsManagement;

import com.fdm.RequestDataClasses.RequestData;

public class UpdateRequest{
	private RequestData requestData= RequestData.getInstance();
	
	public void updateRequest(Requests request)
	{
		String username= request.getUsername();
		String requestText= request.getRequestText();
		int index= getRequestIndex(username, requestText);
		if(index != requestData.getLength())
			requestData.replaceRequest(index, request);
	}
	
	public int getRequestIndex(String username, String request)
	{
		int index;
		Requests existingRequest = null;
		String existingUsername, existingRequestText;
		for(index=0; index< requestData.getLength(); index++)
		{
			existingRequest= requestData.getRequest(index);
			existingUsername= existingRequest.getUsername();
			existingRequestText= existingRequest.getRequestText();
			if(existingUsername.equals(username) && existingRequestText.equals(request))
				break;
		}
		return index;
	}
}
