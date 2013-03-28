package com.fdm.TestXMLWriters2;

import org.junit.Before;
import org.junit.Test;

import com.fdm.UserDataClasses.NewUserData;
import com.fdm.Users.User;
import com.fdm.XMLWriters.NewUserDataWriter;

public class TestNewUserDataWriter {
	NewUserData currentUsersData=new NewUserData();
	User user;
	NewUserDataWriter userDataWrite= new NewUserDataWriter(currentUsersData);
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

}
