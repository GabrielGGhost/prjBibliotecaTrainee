package com.epiousion.model;

import java.util.Date;

public class Book {
	
	private int id;
	private String title;
	private int year;
	private String description;
	private String picturePath;
	private int tombo;
	private String author;
	
	
	public Book(int id, String title, int year, String description, String picturePath, int tombo, String author) {
		this(title, year, description, picturePath, tombo, author);
		this.id = id;

	}
	
	public Book(String title, int year, String description, String picturePath, int tombo, String author) {
		this.setTitle(title);
		this.setYear(year);
		this.setDescription(description);
		this.setPicturePath(picturePath);
		this.setTombo(tombo);
		this.setAuthor(author);
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicturePath() {
		return this.picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public int getTombo() {
		return this.tombo;
	}
	public void setTombo(int tombo) {
		this.tombo = tombo;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
