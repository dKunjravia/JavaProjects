package com.fdm.DatabaseClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RequestTableAccessor {
	private Connection dbConnection;
	private String tableName;
	private Statement selectStatement;
	private Statement insertStatement;
	private Statement updateStatement;
	private Statement deleteStatement;
	
	public RequestTableAccessor(String table) throws SQLException
	{
		tableName= table;
	}
	
	public ResultSet select(String fieldName) throws SQLException
	{		
		dbConnection= new DatabaseConnection().getDbConnection();
		selectStatement= dbConnection.createStatement();
		ResultSet resultSet= selectStatement.executeQuery("SELECT "+ fieldName+" FROM "+ tableName);
		return resultSet;
	}
	
	public ResultSet select(String fieldName,String username) throws SQLException
	{				
		dbConnection= new DatabaseConnection().getDbConnection();
		selectStatement= dbConnection.createStatement();
		ResultSet resultSet= selectStatement.executeQuery("SELECT "+ fieldName+" FROM "+ tableName +" WHERE username ='"+ username+"'");
		return resultSet;
	}
	
	public int insert(String username, String password, String status, String banned) throws SQLException
	{		
		dbConnection= new DatabaseConnection().getDbConnection();
		insertStatement= dbConnection.createStatement();
		String query="INSERT INTO "+ tableName + " VALUES('" +username +"','"+ password +"','"+ status +"','"+ banned +"')";
		int count= insertStatement.executeUpdate(query);
		dbConnection.close();
		return count;
	}
	
	public int update(String fieldname, String oldValue, String newValue) throws SQLException
	{
		dbConnection= new DatabaseConnection().getDbConnection();
		updateStatement= dbConnection.createStatement();
		String query="UPDATE "+ tableName +" SET "+fieldname+"='"+newValue+"' " +
				  "WHERE "+fieldname+"='"+oldValue+"'";
		int count= updateStatement.executeUpdate(query);
		dbConnection.close();
		return count;
	}
	
	public int delete(String fieldname, String value) throws SQLException
	{
		dbConnection= new DatabaseConnection().getDbConnection();
		deleteStatement= dbConnection.createStatement();
		String query="DELETE FROM "+ tableName + " WHERE "+fieldname+"='"+value+"'";
		int count= deleteStatement.executeUpdate(query);
		dbConnection.close();
		return count;
	}
	
	public void closeConnection() throws SQLException
	{
		dbConnection.close();
	}
}
