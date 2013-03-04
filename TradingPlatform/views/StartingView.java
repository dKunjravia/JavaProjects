package com.fdm.views;

import java.util.Scanner;

public class StartingView {
	private int choice;
	public StartingView()
	{
		choice= -1;
	}
	
	public int getChoice()
	{
		System.out.println("What will you like to do?");
		System.out.println("1) Login \n2)Register \n3)Exit");
		Scanner input= new Scanner(System.in);
		try{
			choice= Integer.parseInt(input.nextLine());
			return choice;
		}
		catch(NumberFormatException ex)
		{
			return choice;
		}
	}
	
	public void invalidChoice()
	{
		System.out.println("Invalid Choice");
	}
}
