package com.example.web.events;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.example.persistence.model.User;
import com.example.service.IUserService;
@Component
public class RegistrationEventListener implements ApplicationListener<RegistrationCompleteEvent>{

	@Autowired
	RegistrationMailSender registrationMailSender;

	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		registrationMailSender.confirmRegistration(event);
		
	}
	

	

}
