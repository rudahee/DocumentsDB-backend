package com.docdb.model.entity.dto;

public class LoginDataReceivedDTO {

	private String username;
	private String password;
	
	public LoginDataReceivedDTO() {
		super();
	}
	
	public LoginDataReceivedDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
