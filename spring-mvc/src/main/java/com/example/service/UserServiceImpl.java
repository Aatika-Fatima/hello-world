package com.example.service;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.persistence.model.PasswordResetToken;
import com.example.persistence.model.User;
import com.example.persistence.model.VerificationToken;
import com.example.persistence.repository.IPasswordResetTokenRepository;
import com.example.persistence.repository.IRoleRepository;
import com.example.persistence.repository.IUserRepository;
import com.example.persistence.repository.IVerificationTokenRepository;
import com.example.service.exceptions.EmailDoesNotExistException;
import com.example.service.exceptions.TokenDoesNotExistException;
import com.example.service.exceptions.UserAlreadyExistException;
import com.example.web.dto.UserDto;
import com.example.web.events.RegistrationMailSender;

@Component
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;
	@Autowired
	IRoleRepository roleRepository;
	@Autowired
	IVerificationTokenRepository tokenRepository;
	@Autowired
	IPasswordResetTokenRepository passwordTokenResetRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	RegistrationMailSender registrationMailSender;

	@Override
	public User registerNewUserCount(UserDto userDto) {
		if (userDto.getEmail() == null) {
			throw new NullPointerException("Email cannot be null");
		}
		if (emailExists(userDto.getEmail())) {
			throw new UserAlreadyExistException("User Already Exists");
		}
		User user = new User();
		user.setUserName(userDto.getUserName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEmail(userDto.getEmail());
		user.setEnabled(false);
		user.setRoles(Arrays.asList(roleRepository.findRoleByName("ROLE_USER")));
		user = userRepository.registerNewUserAccount(user);
		return user;
	}

	private boolean emailExists(String email) {
		if (userRepository.findUserByEmail(email) != null)
			return true;
		return false;
	}

	@Override
	public void createVerficationTokenForUser(User user, String token) {
		VerificationToken verificationToken = new VerificationToken(token, user);
		tokenRepository.create(verificationToken);
		System.out.println(verificationToken.getToken());
	}

	public User getUser(String verificationToken) {
		User user = tokenRepository.findByToken(verificationToken).getUser();
		return user;
	}

	@Override
	public VerificationToken getVerificationToken(String VerificationToken) {
		VerificationToken verificationToken = tokenRepository.findByToken(VerificationToken);
		if (verificationToken == null)
			throw new TokenDoesNotExistException("Token Does Not exist");
		return verificationToken;
	}

	@Override
	public void updateUserConfirmation(User u) {
		User user = userRepository.get(u.getId());
		user.setEnabled(true);
		userRepository.update(user);

	}

	@Override
	public boolean validateUser(String userName, String password) {

		return userRepository.validateUser(userName, password);
	}

	@Override
	public VerificationToken generateNewVerficationToken(String token) {
		getVerificationToken(token);
		VerificationToken verificationToken = tokenRepository.generateNewVerificationToken(token);

		return verificationToken;

	}

	@Override
	public void sendEmail(Locale locale, String token, User user) {
		registrationMailSender.confirmRegistration(locale, token, user);

	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findUserByEmail(String email) {
		try {
			System.out.println("Email = " + email);
			User user = userRepository.findUserByEmail(email);
			if (user == null) {
				throw new EmailDoesNotExistException("Email Does Not Exist");
			}
			return user;
		} catch (NullPointerException ede) {
			System.out.println(ede.getMessage());
			// ede.printStackTrace();
			return null;
		}
	}

	public void resendRegistrationToken(String email) {
		User user = findUserByEmail(email);

		if (user != null) {
			Locale locale = Locale.getDefault();
			VerificationToken verificationToken = tokenRepository.findByUser(user);
			verificationToken = generateNewVerficationToken(verificationToken.getToken());
			registrationMailSender.confirmRegistration(locale, verificationToken.getToken(), user);
			System.out.println(verificationToken.getToken());
		}

	}

	public void createPasswordResetTokenForUser(User user, String token) {
		PasswordResetToken passwordResetToken = new PasswordResetToken(token, user);
		passwordTokenResetRepository.create(passwordResetToken);
	}

	@Override
	public boolean updatePassword(String userId, String newPassword) {
		User user = userRepository.get(Integer.parseInt(userId));
		if( user != null ){
			user.setPassword(newPassword);
			userRepository.update(user);
			System.out.println("Updated");
			return true;
		}
		return false;
	}
}
