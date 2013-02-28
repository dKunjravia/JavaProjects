package com.fdm.RequestsManagement;

import com.fdm.RequestDataClasses.RequestData;

public class AddRequest{
	private RequestData requestData= RequestData.getInstance();
	public void addRequest(Requests request)
	{
		requestData.addRequest(request);
	}
}
