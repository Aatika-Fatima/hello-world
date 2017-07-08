package com.example.persistence.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({@NamedQuery(name="findByToken", query="from VerificationToken where token=:token"),
	@NamedQuery(name="findByUser", query="from VerificationToken where user=:user ")})
public class VerificationToken {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(columnDefinition="number(4)")
	private int tokenId; 
	
	private String token; 
	
	@OneToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="user_id", referencedColumnName="")
	private User user; 

	private Date expiryDate;

	public VerificationToken(String token, User user) {
		super();
		this.token = token;
		this.user = user;
		this.expiryDate = calculateExpiryDate();
	}
	
	private Date calculateExpiryDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Timestamp(calendar.getTime().getTime()));
		calendar.add(Calendar.MINUTE, 24*60);
		return new Date(calendar.getTime().getTime());
	}

	public VerificationToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	
}
