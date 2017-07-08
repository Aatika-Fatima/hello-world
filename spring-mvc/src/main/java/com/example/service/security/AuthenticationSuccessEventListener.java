package com.example.service.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessEventListener
implements ApplicationListener<AuthenticationSuccessEvent>{

	@Autowired
	LoginAttemptService loginAttemptService; 
	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		WebAuthenticationDetails webAuthenticationDetails = 
			(WebAuthenticationDetails) event.getAuthentication();
		loginAttemptService.loginSucceeded(webAuthenticationDetails.getRemoteAddress());
	}

}
