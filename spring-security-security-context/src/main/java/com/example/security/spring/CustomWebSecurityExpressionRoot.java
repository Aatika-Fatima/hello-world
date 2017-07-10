package com.example.security.spring;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

import com.security.web.model.AppUser;

public class CustomWebSecurityExpressionRoot extends WebSecurityExpressionRoot{

	public CustomWebSecurityExpressionRoot(Authentication authentication, FilterInvocation filterInvocation) {
		super(authentication, filterInvocation);
		// TODO Auto-generated constructor stub
	}
	
	public boolean hasAgeOver18(){
		AppUser user = (AppUser)this.getPrincipal();
		System.err.println("Age of user = " + user.getAge());
		return user.getAge()>18;
	}

}
