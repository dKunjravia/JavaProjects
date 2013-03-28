package com.fdm.TestDatabaseClasses;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.fdm.DatabaseClasses.DatabaseConnection;

public class TestDatabaseConnection 
{
	DatabaseConnection dbConnection;
	@Before
	public void initialize() {
		try {
			dbConnection = new DatabaseConnection();
		} catch (SQLException se) {
		} 
	}
	@Test
	public void testGetDbConnection() throws SQLException {
		assertNotNull(dbConnection.getDbConnection());
		dbConnection.closeConnection();
	}

}
