package com.example.web.events;

import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.example.persistence.model.User;
import com.example.service.IUserService;

@Component
public class RegistrationMailSender {
	@Autowired
	private IUserService userService; 
	
	@Autowired
	private MessageSource messageSource; 
	
	@Autowired
	private MailSender mailSender; 
	
	@Value("${server.contextpath}")
	private String contextPath; 
	
	@Async
	public void confirmRegistration(RegistrationCompleteEvent event){
		User user = event.getUser();
		String token = UUID.randomUUID().toString();
		userService.createVerficationTokenForUser(user, token);
		 
		SimpleMailMessage mailMessage = new SimpleMailMessage(); 
		mailMessage.setTo(user.getEmail());
		mailMessage.setText(user.getEmail());
		mailMessage.setSubject("Registration Confirmation");
		String message = messageSource.getMessage("message.registraion.successful", null, event.getLocale());
		mailMessage.setText(message + "  " + contextPath+ "/registrationConfirmation.htm?token="+token);
		if(mailSender != null)
			mailSender.send(mailMessage);
		else
		{
			System.out.println("Mail Sender not configured");
		}
	}
	
	
	@Async
 	public void confirmRegistration(Locale locale, String token, User user){
		SimpleMailMessage mailMessage = new SimpleMailMessage(); 
		mailMessage.setTo(user.getEmail());
		mailMessage.setSubject("Registration Confirmation");
		String message = messageSource.getMessage("message.registraion.successful", null, locale);
		mailMessage.setText(message + "  " + contextPath+ "/registrationConfirmation.htm?token="+token);
		System.out.println(token);
		System.out.println(user.getEmail());
		mailSender.send(mailMessage);
	}
	
	@Async
	public void passwordResetEmail(Locale locale, String token, User user){
		String url = contextPath+"/changePassword.htm?id="+user.getId()+"&token="+token;
		String message = messageSource.getMessage("message.resetPassword",null, locale);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setSubject("Password Reset");
 		mailMessage.setText(message + "  " + url);
		mailSender.send(mailMessage);
	}
	
}
