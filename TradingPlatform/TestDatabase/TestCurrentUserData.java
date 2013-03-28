package com.fdm.TestDatabase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdm.UserDataClasses.CurrentUserData;
import com.fdm.UserDataClasses.UserData;
import com.fdm.Users.SystemAdmin;
import com.fdm.Users.User;

public class TestCurrentUserData {
	
	private User user1;
	private UserData currentUsers;
	private final String USERNAME= "Dean";
	private final String PASSWORD= "Kunjravia";
	private final String STATUS= "Admin";
	@Before
	public void initiaize()
	{
		currentUsers= new CurrentUserData();
		user1= new SystemAdmin();
		user1.setUsername(USERNAME);
		user1.setPassword(PASSWORD);
		user1.setStatus(STATUS);
		currentUsers.addUser(user1);
	}
	
	@Test
	public void testGetUser() {
		assertEquals(currentUsers.getUser(USERNAME), user1);
	}

	@Test
	public void testUserExists() {
		assertTrue(currentUsers.userExists(user1.getUsername()));
	}

	@Test
	public void testGetLength() {
		assertEquals(currentUsers.getLength(), 1);
	}

	@Test
	public void testDeleteUser() {
		currentUsers.deleteUser(USERNAME);
		assertEquals(currentUsers.getLength(), 0);
	}
	
	@After
	public void clear()
	{
		if(currentUsers.getLength()> 0)
		currentUsers.clearUserdata();
	}
}
