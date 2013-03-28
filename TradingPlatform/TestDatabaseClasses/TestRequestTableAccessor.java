package com.fdm.TestDatabaseClasses;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.fdm.DatabaseClasses.RequestTableAccessor;

public class TestRequestTableAccessor {
	RequestTableAccessor requestTable;
	String USERNAME="greg";
	String field1="username";
	String field2="adminName";
	final int NUMBERS_OF_RAW_CHANGED=1; 
	boolean found;
	@Before
	public void initialize() {
		try {
			requestTable= new RequestTableAccessor("REQUEST_DATA");			
		} catch (SQLException se) {
		}
	}

	@Test
	public void testOneArgumentSelect() throws SQLException {
		ResultSet usernameArray= requestTable.select(field1);
		while(usernameArray.next())
		{
			if(usernameArray.getString(field1).equals("greg"))
				found = true;
		}
		requestTable.closeConnection();
		assertTrue(found);
	}

	@Test
	public void testTwoArgumentSelect() throws SQLException {
		ResultSet usernameArray= requestTable.select(field1,USERNAME);
		while(usernameArray.next())
		{
			if(usernameArray.getString(field1).equals("greg"))
				found = true;
		}
		requestTable.closeConnection();
		assertTrue(found);
	}

	@Test
	public void testInsert() throws SQLException {
		requestTable.insert("Change Status","outstanding","andrew", "dean");
		assertEquals(NUMBERS_OF_RAW_CHANGED, count);
	}

	@Test
	public void testUpdate() throws SQLException {
		requestTable.update(field2, "dean", "deank");
		assertEquals(NUMBERS_OF_RAW_CHANGED, count);
	}

	@Test
	public void testDelete() throws SQLException {
		requestTable.delete("username", "andrew");
		assertEquals(NUMBERS_OF_RAW_CHANGED, count);
	}
}
