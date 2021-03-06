package com.epiousion.model;

public class Genre {
	
	private int id;

	private String name;
	
	public Genre(int id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	public Genre(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
