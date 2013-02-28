package com.fdm.DatabaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private String dbURL="jdbc:oracle:thin:@oracle.fdmgroup.com:1521:campus";
	private String dbUsername="deankunjravia1";
	private String dbPassword="DKJ524kR";
	private Connection dbConnection;
	
	public DatabaseConnection() throws SQLException
	{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		dbConnection= DriverManager.getConnection(dbURL,dbUsername,dbPassword);	
	}
	
	public Connection getDbConnection() {
		return dbConnection;
	}
	
	public void closeConnection() throws SQLException
	{
		dbConnection.close();
	}
}
