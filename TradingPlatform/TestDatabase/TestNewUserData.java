package com.fdm.TestDatabase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdm.UserDataClasses.NewUserData;
import com.fdm.UserDataClasses.UserData;
import com.fdm.Users.SystemAdmin;
import com.fdm.Users.User;

public class TestNewUserData {

	private User user1;
	private UserData newUsers;
	private final String USERNAME= "Dean";
	private final String PASSWORD= "Kunjravia";
	private final String STATUS= "Admin";
	@Before
	public void initiaize()
	{
		newUsers= new NewUserData();
		user1= new SystemAdmin();
		user1.setUsername(USERNAME);
		user1.setPassword(PASSWORD);
		user1.setStatus(STATUS);
		newUsers.addUser(user1);
	}
	
	@Test
	public void testGetUser() {
		assertEquals(newUsers.getUser(USERNAME), user1);
	}

	@Test
	public void testGetLength() {
		assertEquals(newUsers.getLength(), 1);
	}

	@Test
	public void testUserExists() {
		assertTrue(newUsers.userExists(user1.getUsername()));
	}

	@Test
	public void testDeleteUser() {
		newUsers.deleteUser(USERNAME);
		assertEquals(newUsers.getLength(), 0);
	}

	@After
	public void clear()
	{
		if(newUsers.getLength()> 0)
			newUsers.clearUserdata();
	}

}
