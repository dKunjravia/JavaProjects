package com.fdm.TestUsers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fdm.Users.Shareholder;
import com.fdm.Users.User;

public class TestShareholder {
	private User newUser;
	private final String username= "Hansam";
	private final String password= "Park";
	private final String status= "Shareholder";
	private final boolean banned= false;
	@Before
	public void initialize()
	{
		newUser = new Shareholder();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setStatus(status);
		newUser.setBanned(banned);
	}
	
	@Test
	public void testGetUsername() {
		assertEquals(newUser.getUsername(),username);
	}

	@Test
	public void testGetPassword() {
		assertEquals(newUser.getPassword(),password);
	}

	@Test
	public void testGetStatus() {
		assertEquals(newUser.getStatus(),status);
	}
	
	@Test
	public void testGetBanned() {
		assertFalse(newUser.isBanned());
	}

}
