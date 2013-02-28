package com.fdm.Users;

public class User {
	private String username;
	private String password;
	private String status;
	private boolean banned;
	
	public boolean isBanned() {
		return banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	public void setUsername(String username) {
		// TODO Auto-generated method stub
		this.username = username;
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public void setStatus(String status) {
		// TODO Auto-generated method stub
		this.status = status;
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return status;
	}
	
}
