package com.fdm.TestXMLWriters2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdm.UserDataClasses.CurrentUserData;
import com.fdm.Users.User;
import com.fdm.XMLWriters.CurrentUserDataWriter;

public class TestCurrentUserDataWriter {
	CurrentUserData currentUsersData=new CurrentUserData();
	User user;
	CurrentUserDataWriter userDataWrite= CurrentUserDataWriter.getInstance(currentUsersData);
	@Before
	public void initialize()
	{
		user= new User();
		user.setUsername("Dean");
		user.setPassword("Kunjravia");
		user.setStatus("Admin");
		user.setBanned(false);
		currentUsersData.addUser(user);
		user= new User();
		user.setUsername("DeanK");
		user.setPassword("KunjraviaD");
		user.setStatus("Shareholder");
		user.setBanned(false);
		currentUsersData.addUser(user);
	}
	@Test
	public void testWriteData() {
		userDataWrite.writeData();
	}
	@After
	public void printData()
	{
		currentUsersData.clearUserdata();
	}
}
