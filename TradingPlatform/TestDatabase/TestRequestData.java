package com.fdm.TestDatabase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdm.RequestDataClasses.RequestData;
import com.fdm.RequestsManagement.Requests;

public class TestRequestData {

	private Requests request1;
	RequestData requestData= RequestData.getInstance();
	private int index= 0;
	private final String username= "Dean";
	private final String adminName= "John";
	private final String request= "Register";
	private final String status= "Outstanding";
	
	@Before
	public void initiaize()
	{
		request1= new Requests();
		request1.setUsername(username);
		request1.setAdminName(adminName);
		request1.setStatus(status);
		request1.setRequestText(request);
		requestData.addRequest(request1);
	}
	@Test
	public void testGetRequest() {
		assertEquals(requestData.getRequest(index), request1);
	}

	@Test
	public void testRequestExists() {
		assertTrue(requestData.requestExists(request1));
	}

	@Test
	public void testGetLength() {
		assertEquals(requestData.getLength(), 1);
	}
	
	@After
	public void clear()
	{
		requestData.clearRequestdata();
	}

}
