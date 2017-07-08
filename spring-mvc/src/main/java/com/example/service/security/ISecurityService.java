package com.example.service.security;

public interface ISecurityService {
	public String validatePasswordResetToken(long id, String token);
}
