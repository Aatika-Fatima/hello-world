package com.example.persistence.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Author_User implements Serializable {
	private int author_user_id;

	public int getAuthor_user_id() {
		return author_user_id;
	}

	public void setAuthor_user_id(int author_user_id) {
		this.author_user_id = author_user_id;
	}

	public Author_User() {
		super();
	}
	
}
