package com.example.persistence.repository;

import com.example.persistence.model.PasswordResetToken;
import com.example.persistence.model.User;

public interface IPasswordResetTokenRepository   extends IDao<PasswordResetToken>{
	public PasswordResetToken findByToken(String token);
}
