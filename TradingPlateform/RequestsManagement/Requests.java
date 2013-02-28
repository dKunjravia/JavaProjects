package com.fdm.RequestsManagement;

public class Requests {
	private String requestText;
	private String status;
	private String username;
	private String adminName;
	
	public String getRequestText() {
		return requestText;
	}
	
	public void setRequestText(String request) {
		this.requestText = request;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAdminName() {
		return adminName;
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
}
