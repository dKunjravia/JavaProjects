package com.fdm.TestUsers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import com.fdm.Users.SystemAdmin;
import com.fdm.Users.User;

public class TestSystemAdmin {
	private User newUser;
	private final String username= "Dean";
	private final String password= "Kunjravia";
	private final String status= "Admin";
	private final boolean banned= false;
	@Before
	public void initialize()
	{
		newUser = new SystemAdmin();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setStatus(status);
		newUser.setBanned(banned);
	}
	
	@Test
	public void testGetUsername() {
		assertEquals(newUser.getUsername(),"Dean");
	}

	@Test
	public void testGetPassword() {
		assertEquals(newUser.getPassword(),"Kunjravia");
	}

	@Test
	public void testGetStatus() {
		assertEquals(newUser.getStatus(),"Admin");
	}
	
	@Test
	public void testGetBanned() {
		assertFalse(newUser.isBanned());
	}

}
