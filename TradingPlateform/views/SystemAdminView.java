package com.fdm.views;

import java.util.Scanner;

import com.fdm.RequestDataClasses.RequestData;
import com.fdm.RequestsManagement.Requests;

public class SystemAdminView {
	private int choice;
	private RequestData requestData= RequestData.getInstance();
	
	public SystemAdminView()
	{
		choice= -1;
	}
	
	public void startingPage()
	{
		boolean invalidChoice=true;
		while(invalidChoice)
		{
			choice= mainMenu();
			if(choice == -1 || choice < 0 || choice > 5)
				invalidChoice();
			else
				invalidChoice= false;
		}
	}
	
	public String getUsername()
	{
		System.out.println("Please enter username: ");
		Scanner input= new Scanner(System.in);
		return input.nextLine();		
	}
	
	public int getChoice() {
		return choice;
	}

	private int mainMenu()
	{
		System.out.println("What would you like to do?" +
							"Please choose one:");
		System.out.println( "1) Add User \n2) Delete User \n3) Ban User " +
							"\n4) Change Permission \n5) Log Off");
		Scanner input= new Scanner(System.in);
		try{
			return Integer.parseInt(input.nextLine());
		}catch(NumberFormatException e){
			return -1;
		}
	}
	
	public void invalidChoice()
	{
		System.out.println("Invalid input");
	}
	
	public void showNewUserRequests()
	{
		int index;
		Requests request;
		for(index = 0; index< requestData.getLength(); index++)
		{
			request=requestData.getRequest(index);
			if(request.getRequestText().equals("Register"))
			{
				System.out.println("Username: "+ request.getUsername());
			}
		}
	}
}
