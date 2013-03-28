package com.fdm.TestRequestsManagement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdm.RequestDataClasses.RequestData;
import com.fdm.RequestsManagement.AddRequest;
import com.fdm.RequestsManagement.Requests;

public class TestAddRequest {
	
	private AddRequest newRequest;
	RequestData requestData= RequestData.getInstance();
	private Requests request1;
	private final String username= "Dean";
	private final String adminName= "John";
	private final String requestText= "Register";
	private final String status= "Outstanding";
	
	@Before
	public void initiaize()
	{
		newRequest= new AddRequest();
		request1= new Requests();
		request1.setUsername(username);
		request1.setAdminName(adminName);
		request1.setStatus(status);
		request1.setRequestText(requestText);
	}
	
	@Test
	public void testAddRequest() {
		newRequest.addRequest(request1);
		assertTrue(requestData.requestExists(request1));
	}

	@After
	public void clear()
	{
		requestData.clearRequestdata();
	}
}
