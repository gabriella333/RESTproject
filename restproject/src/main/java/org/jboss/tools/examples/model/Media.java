package org.jboss.tools.examples.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Media {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String author;
	private String title;

	public Media() {
	}

	public Media(String author, String title) {
		this.author = author;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		return "Book : " + this.author + " " + this.title;
	}

}