package com.example.persistence.repository;

import com.example.persistence.model.User;
import com.example.persistence.model.VerificationToken;

public interface IVerificationTokenRepository extends IDao<VerificationToken>{
	 VerificationToken findByToken(String token);
	 VerificationToken findByUser(User user);
	 VerificationToken generateNewVerificationToken(String verificationToken);
	 
}
