package com.fdm.TestControllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import com.fdm.Controllers.LoginController;
import com.fdm.UserDataClasses.CurrentUserData;
import com.fdm.UserDataClasses.UserData;
import com.fdm.Users.SystemAdmin;

public class TestLoginController {
	private LoginController testObject;
	private SystemAdmin admin;
	private UserData currentUsers;
	private final String username= "Dean";
	private final String password= "Kunjravi";
	private final String status= "Admin";
	
	@Before
	public void initialize()
	{
		currentUsers= new CurrentUserData();
		testObject= new LoginController();
		admin= new SystemAdmin();
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setStatus(status);
		currentUsers.addUser(admin);
	}
	
	@Test
	public void testVerifyLogin() {
		assertTrue(testObject.verifyLogin(admin.getUsername(),admin.getPassword()));
	}
	
	@After
	public void clear()
	{
		currentUsers.clearUserdata();
	}
}
