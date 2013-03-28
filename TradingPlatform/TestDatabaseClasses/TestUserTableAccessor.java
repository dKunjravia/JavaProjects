package com.fdm.TestDatabaseClasses;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.fdm.DatabaseClasses.UserTableAccessor;

public class TestUserTableAccessor {
	UserTableAccessor userTable;
	String USERNAME="dean";
	String field="username";
	final int NUMBERS_OF_RAW_CHANGED=1; 
	int count;
	boolean found;
	@Before
	public void initialize() {
		try {
			userTable= new UserTableAccessor("current_user_data");
			
		} catch (SQLException se) {
		}
	}
	
	@Test
	public void testOneArgumentSelect() throws SQLException {
		ResultSet usernameArray= userTable.select(field);
		while(usernameArray.next())
		{
			if(usernameArray.getString(field).equals("dean"))
				found = true;
		}
		userTable.closeConnection();
		assertTrue(found);
	}

	@Test
	public void testTwoArgumentSelect() throws SQLException {
		ResultSet usernameArray= userTable.select(field,USERNAME);
		while(usernameArray.next())
		{
			if(usernameArray.getString(field).equals("dean"))
				found = true;
		}
		userTable.closeConnection();
		assertTrue(found);
	}
	
	@Test
	public void testInsert() throws SQLException {
		count= userTable.insert("andrew", "11111", "Shareholder", "false");
		assertEquals(NUMBERS_OF_RAW_CHANGED, count);
	}

	@Test
	public void testUpdate() throws SQLException {
		count= userTable.update(field, "andrew", "andy");
		assertEquals(NUMBERS_OF_RAW_CHANGED, count);
	}

	@Test
	public void testDelete() throws SQLException {
		count= userTable.delete("username", "andy");
		assertEquals(NUMBERS_OF_RAW_CHANGED, count);
	}
}
