package com.fdm.TestRequestsManagement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdm.RequestDataClasses.RequestData;
import com.fdm.RequestsManagement.Requests;
import com.fdm.RequestsManagement.ViewRequest;

public class TestViewRequest {
	
	private ViewRequest newRequest;
	RequestData requestData= RequestData.getInstance();
	private Requests request1;
	private int index= 0;
	private final String username= "Dean";
	private final String adminName= "John";
	private final String requestText= "Register";
	private final String status= "Outstanding";
	
	@Before
	public void initiaize()
	{
		newRequest=new ViewRequest();
		request1= new Requests();
		request1.setUsername(username);
		request1.setAdminName(adminName);
		request1.setStatus(status);
		request1.setRequestText(requestText);
		requestData.addRequest(request1);
	}
	
	@Test
	public void testGetRequest() {
		assertEquals(newRequest.getRequest(index), request1);
	}
	
	@After
	public void clear()
	{
		requestData.clearRequestdata();
	}
}
