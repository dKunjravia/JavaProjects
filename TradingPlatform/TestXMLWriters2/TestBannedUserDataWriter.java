package com.fdm.TestXMLWriters2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdm.UserDataClasses.BannedUserData;
import com.fdm.Users.User;
import com.fdm.XMLWriters.BannedUserDataWriter;

public class TestBannedUserDataWriter {
	BannedUserData currentUsersData=new BannedUserData();
	User user;
	BannedUserDataWriter userDataWrite= BannedUserDataWriter.getInstance(currentUsersData);
	@Before
	public void initialize()
	{
		user= new User();
		user.setUsername("Michael");
		user.setPassword("00000");
		user.setStatus("Shareholder");
		user.setBanned(true);
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
