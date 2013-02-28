package com.fdm.views;

import java.util.Scanner;

public class LoginView {
	private String username;
	private String password;
		
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public void getUserInput()
	{
		Scanner input= new Scanner(System.in);
		System.out.print("Username: ");
		this.username= input.nextLine();
		System.out.print("Password: ");
		this.password= input.nextLine();
	}
	
	public void loginFailed()
	{
		System.out.println("User do not exist");
	}
	
	public void loginSuccess()
	{
		System.out.println("Welcom " + username);
	}
}
