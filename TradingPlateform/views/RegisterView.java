package com.fdm.views;

import java.util.Scanner;

public class RegisterView {
	
	private String username;
	private String password;
	private String status;
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getStatus() {
		return status;
	}

	public void getUserInput()
	{
		System.out.println("Welcome to Registration form. " +
							"Please provide following information.");
		Scanner input= new Scanner(System.in);
		System.out.print("Username: ");
		this.username= input.nextLine();
		System.out.print("Password: ");
		this.password= input.nextLine();
		System.out.print("Type: ");
		this.status= input.nextLine();
	}
	
	public void registrationFailed()
	{
		System.out.println("Registeration Fail");
		System.out.println("User with that username already exists");
	}
	
	public void registrationSuccess()
	{
		System.out.println("Registered");
	}
}
