package com.epiousion.model;

import java.util.Date;

public class User {
	
	private int id;
	private String name;
	private String username;
	private String password;
	private boolean admin;
	private String email;
	private String phone;
	private Boolean active;
	private Date dataCadastro;
	
	public User(){}
	
	public User(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	
	public User(String username, String password, boolean admin) {
		this(username, password);
		this.setAdmin(admin);
	}
	
	public User(int id, String username, String password, boolean admin) {
		this(username, password, admin);
		this.setId(id);
	}
	
	public User(int id, String name, String username, String password, boolean admin, String email, String phone,
			Boolean active, Date dataCadastro) {
		this(id, username, password, admin);
		this.setName(username);
		this.setActive(active);
		this.setEmail(email);
		this.setPhone(phone);
		this.setDataCadastro(dataCadastro);
	}
	
	public User(int id, String name, String email, String phone) {
		this.setId(id);
		this.setName(name);
		this.setEmail(email);
		this.setPhone(phone);
	}
	
	public User(String name, String username, String password, boolean admin, String email, String phone){
		this.setName(name);
		this.setUsername(username);
		this.setPassword(password);
		this.setAdmin(admin);
		this.setEmail(email);
		this.setPhone(phone);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
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
