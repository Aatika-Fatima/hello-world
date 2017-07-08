package com.example.web.dto;

import javax.validation.constraints.NotNull;

import com.example.validation.PasswordMatches;
import com.example.validation.ValidEmail;
import com.example.validation.ValidPhone;

@PasswordMatches
public class UserDto {
	
	@NotNull
	private String userName; 
	
	@NotNull
	private String password; 
	
	@NotNull
	private String reEnterPassword;
	
	@ValidEmail
	@NotNull
	private String email;
/*	
	@ValidPhone
	private String phoneNumber; */
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReEnterPassword() {
		return reEnterPassword;
	}
	public void setReEnterPassword(String reEnterPassword) {
		this.reEnterPassword = reEnterPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserDto [userName=" + userName + ", password=" + password + ", reEnterPassword=" + reEnterPassword
				+ ", email=" + email + "]";
	} 
	
	
	
}
