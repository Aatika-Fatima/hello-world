package com.example.service.security;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.persistence.model.PasswordResetToken;
import com.example.persistence.model.User;
import com.example.persistence.repository.IPasswordResetTokenRepository;
@Component
public class SecurityServiceImpl implements ISecurityService {

	@Autowired
	IPasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public String validatePasswordResetToken(long id, String token) {
		PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
		if ((passwordResetToken == null) || (passwordResetToken.getUser().getId() != id))
			return "invalidToken";

		Calendar calendar = Calendar.getInstance();
		if (((passwordResetToken.getExpiryDate().getTime()) - (calendar.getTime().getTime())) <= 0) {
			return "expired";
		}
		User user = passwordResetToken.getUser();
	 	Authentication authentication = new UsernamePasswordAuthenticationToken(user, null,
				Arrays.asList(new SimpleGrantedAuthority("CHANGE_PASSWORD_PRIVILEGE")));
		SecurityContextHolder.getContext().setAuthentication(authentication); 
		return null;
	}

}
