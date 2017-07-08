package com.example.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Author {
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.AUTO) private int authorId;
	 */
	// @EmbeddedId
	@Id
    @Column(name = "AUTHOR_ID", nullable = false)
	private int authorId;
	@Column(name = "ENABLED", nullable = false, length = 1)
	private boolean enabled;

	@OneToOne
	@MapsId
	@JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID", nullable = false)
	User user;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	

}
