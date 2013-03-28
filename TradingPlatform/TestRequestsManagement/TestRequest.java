package com.fdm.TestRequestsManagement;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import com.fdm.RequestsManagement.Requests;

public class TestRequest {
	private Requests testObject;
	private final String username= "Dean";
	private final String status= "Complete";
	private final String adminName= "John";
	private final String requestText= "test";
	
	@Before
	public void initialize()
	{
		testObject= new Requests();
		testObject.setUsername(username);
		testObject.setStatus(status);
		testObject.setAdminName(adminName);
		testObject.setRequestText(requestText);
	}
	
	@Test
	public void testGetRequest() {
		assertEquals(testObject.getRequestText(), requestText);
	}

	@Test
	public void testGetStatus() {
		assertEquals(testObject.getStatus(), status);
	}

	@Test
	public void testGetUsername() {
		assertEquals(testObject.getUsername(), username);
	}

	@Test
	public void testGetAdminName() {
		assertEquals(testObject.getAdminName(), adminName);
	}

}
