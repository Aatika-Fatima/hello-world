package com.example.service;

import java.util.Locale;

import com.example.persistence.model.User;
import com.example.persistence.model.VerificationToken;
import com.example.service.exceptions.EmailDoesNotExistException;
import com.example.service.exceptions.TokenDoesNotExistException;
import com.example.service.exceptions.UserAlreadyExistException;
import com.example.web.dto.UserDto;

public interface IUserService {
	public   User registerNewUserCount(UserDto userDto) throws UserAlreadyExistException;
	public void createVerficationTokenForUser(final User user, String token);
 	public VerificationToken getVerificationToken(String VerificationToken)throws TokenDoesNotExistException;
 	public void updateUserConfirmation(User u);
 	
 	public boolean validateUser(String email, String password);
 	
 	public VerificationToken generateNewVerficationToken(String token);
 	public void sendEmail(Locale locale, String token, User user);
 	
 	public User findUserByEmail(String email) throws EmailDoesNotExistException;
 	public void resendRegistrationToken(String email);
 	public void createPasswordResetTokenForUser(User user, String token);
 	
 	public boolean updatePassword(String userId, String newPassword );
}
