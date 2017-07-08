package com.example.service;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.persistence.model.User;
import com.example.service.exceptions.EmailDoesNotExistException;
import com.example.service.exceptions.UserAlreadyExistException;
import com.example.web.dto.UserDto;

@ContextConfiguration(locations = {"classpath:config/service/service-beans.xml", 
	"classpath:config/repository/repository-beans.xml"})
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
	@Autowired
	IUserService userService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

/*	@Test(expected = UserAlreadyExistException.class)
	public void testRegisterNewUserAccount_Exception() {
		UserDto userDto = new UserDto();
		userDto.setEmail("aatika@gmail.com");
		userService.registerNewUserCount(userDto);
	}*/

	//@Test
	public void testUserNameAlreadyExistsException() {
		// test type
		thrown.expect(UserAlreadyExistException.class);
		// test message
		thrown.equals("User Already Exists");
 		UserDto userDto = new UserDto();
		userDto.setEmail("aatika@gmail.com");

		userService.registerNewUserCount(userDto);
	}

	//@Test
	public void testNullPointerException() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("Email cannot be null");
		UserDto userDto = new UserDto();
		userDto.setEmail(null);

		userService.registerNewUserCount(userDto);

	}
	
	//@Test
	public void testRegisterNewUserAccount_Positive(){
		UserDto userDto = new UserDto();
		userDto.setEmail("hamza@gmail.com");
		userDto.setPassword("secret");
		userDto.setReEnterPassword("secret");
		userDto.setUserName("hamza");
		User user = userService.registerNewUserCount(userDto);
		Assert.assertNotNull(user);
	}
 
	@Test(expected=EmailDoesNotExistException.class)
	public void testResendRegistrationToken_Exception( ){
		userService.resendRegistrationToken("donot@gmail.com");
	}
	@Test
	public void testResendRegistrationToken_Positive( ){
		userService.resendRegistrationToken("aatika08@gmail.com");
	}

	@Test
	public void testUpdatePassword(){
		boolean result = userService.updatePassword("2", "secretService");
		Assert.assertEquals(true, result);
	}
}
