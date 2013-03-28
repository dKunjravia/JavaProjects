package com.fdm.TestRequestsManagement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdm.RequestDataClasses.RequestData;
import com.fdm.RequestsManagement.Requests;
import com.fdm.RequestsManagement.UpdateRequest;

public class TestUpdateRequest {
	
	private UpdateRequest newRequest;
	RequestData requestData= RequestData.getInstance();
	private Requests request1,request2;
	private final String username= "Dean";
	private final String adminName= "John";
	private final String requestText= "Register";
	private final String status= "Outstanding";
	private final String status2= "completed";
	
	@Before
	public void initiaize()
	{
		newRequest= new UpdateRequest();
		request1= new Requests();
		request1.setUsername(username);
		request1.setAdminName(adminName);
		request1.setStatus(status);
		request1.setRequestText(requestText);
		requestData.addRequest(request1);
	}
	
	@Test
	public void testUpdateRequest() {
		request2= new Requests();
		request2.setUsername(username);
		request2.setAdminName(adminName);
		request2.setStatus(status2);
		request2.setRequestText(requestText);
		newRequest.updateRequest(request2);
		assertEquals(requestData.getRequest(0), request2);
	}

	@Test
	public void testGetRequestIndex() {
		assertEquals(0, newRequest.getRequestIndex(username, requestText));
	}
	
	@After
	public void clear()
	{
		requestData.clearRequestdata();
	}

}
