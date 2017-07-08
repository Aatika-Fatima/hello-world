package com.example.service.security;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;

@Component
public class AuthenticationFailureListener
implements ApplicationListener<AuthenticationFailureBadCredentialsEvent>{

	@Autowired
	private LoginAttemptService loginAttempService;
	@Override
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
		WebAuthenticationDetails webAuthentication= 
				(WebAuthenticationDetails) event.getAuthentication().getDetails();
		loginAttempService.loginFailed(webAuthentication.getRemoteAddress());
	}

}
