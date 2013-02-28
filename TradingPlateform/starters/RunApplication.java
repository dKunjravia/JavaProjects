package com.fdm.starters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.fdm.Controllers.mainController;

public class RunApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try{
			new mainController().start();
		}
		catch(FileNotFoundException fex){
			System.out.println("File not found error");
		}
		catch(SQLException sqlex){
			System.out.println("Connection to databse failed");
		}
		catch(IOException iex){
		}
	}
	
	}
