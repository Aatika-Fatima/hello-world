package com.example.security.spring;

import org.springframework.security.access.expression.AbstractSecurityExpressionHandler;
import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

public class CustomWebSecurityExpressionHandler extends AbstractSecurityExpressionHandler<FilterInvocation> {

	@Override
	protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication,
			FilterInvocation invocation) {
		// TODO Auto-generated method stub
		CustomWebSecurityExpressionRoot root = new CustomWebSecurityExpressionRoot(authentication, invocation);
		root.setPermissionEvaluator(getPermissionEvaluator());
		root.setTrustResolver(new AuthenticationTrustResolverImpl());
		return root;
	}

}
