package com.fdm.RequestsManagement;

import com.fdm.RequestDataClasses.RequestData;

public class ViewRequest{
	private RequestData requestData= RequestData.getInstance();
	
	public Requests getRequest(int index)
	{
		if(index< 0 || index > requestData.getLength())
			return null;
		return requestData.getRequest(index);
	}
}
