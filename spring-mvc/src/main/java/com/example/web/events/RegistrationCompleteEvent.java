package com.example.web.events;

import java.util.Locale;

 import org.springframework.context.ApplicationEvent;

import com.example.persistence.model.User;

@SuppressWarnings("serial")
public class RegistrationCompleteEvent extends ApplicationEvent{
 
   
	private final String appUrl;
    private final Locale locale;
    private final User user;
	public RegistrationCompleteEvent( String appUrl, Locale locale, User user) {
 		super(user);
		this.appUrl = appUrl;
		this.locale = locale;
		this.user = user;
	}
	public String getAppUrl() {
		return appUrl;
	}
	public Locale getLocale() {
		return locale;
	}
	public User getUser() {
		return user;
	}
    
    
}
