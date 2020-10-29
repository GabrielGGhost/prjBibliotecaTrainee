package com.epiousion.model;

public class User {
	
	private int id;
	private String username;
	private String password;
	private boolean admin;
	
	public User(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	
	public User(int id, String username, String password, boolean admin) {
		this(username, password, admin);
		this.setId(id);
	}
	
	public User(String username, String password, boolean admin) {
		this(username, password);
		this.setAdmin(admin);
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
