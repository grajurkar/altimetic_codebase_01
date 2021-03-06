package com.gaurav.restwebservice.security;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blog")
public class Blog {

	@Id

	private int id;

	private String title;

	private String content;

	public Blog(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public Blog() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
