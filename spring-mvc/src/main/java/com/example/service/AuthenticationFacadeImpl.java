package com.example.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
@Component("authenticationFacade")
public class AuthenticationFacadeImpl implements IAuthenticationFacade{

	@Override
	public Authentication getAuthentication() {
		// TODO Auto-generated method stub
		return SecurityContextHolder.getContext().getAuthentication();
	}

}
