package com.fdm.TestDatabase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdm.UserDataClasses.BannedUserData;
import com.fdm.UserDataClasses.UserData;
import com.fdm.Users.SystemAdmin;
import com.fdm.Users.User;

public class TestBannedUserData {
	
	private User user1;
	private UserData bannedUsers;
	private final String USERNAME= "Dean";
	private final String PASSWORD= "Kunjravia";
	private final String STATUS= "Admin";
	@Before
	public void initiaize()
	{
		bannedUsers= new BannedUserData();
		user1= new SystemAdmin();
		user1.setUsername(USERNAME);
		user1.setPassword(PASSWORD);
		user1.setStatus(STATUS);
		bannedUsers.addUser(user1);
	}
	
	@Test
	public void testGetUser() {
		assertEquals(bannedUsers.getUser(USERNAME), user1);
	}

	@Test
	public void testGetLength() {
		assertEquals(bannedUsers.getLength(), 1);
	}

	@Test
	public void testUserExists() {
		assertTrue(bannedUsers.userExists(user1.getUsername()));
	}

	@Test
	public void testDeleteUser() {
		bannedUsers.deleteUser(USERNAME);
		assertEquals(bannedUsers.getLength(), 0);
	}

	@After
	public void clear()
	{
		if(bannedUsers.getLength()> 0)
			bannedUsers.clearUserdata();
	}

}
