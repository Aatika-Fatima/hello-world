package com.example.repository;

import java.util.Arrays;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
import com.example.persistence.model.Role;
import com.example.persistence.model.User;
import com.example.persistence.repository.IRoleRepository;
import com.example.persistence.repository.IUserRepository;

 
@ContextConfiguration(locations = "classpath:config/repository/repository-beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest   {
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	@Autowired
	IRoleRepository roleRepository;
	@Autowired
	IUserRepository userRepository;

	@Before
	public void setUp() {
		session = sessionFactory.openSession();
	}

	@After
	public void tearDown() {
	}

	//@Test
	public void testfindUserByEmail_Positive() {

		User user = userRepository.findUserByEmail("aatika@gmail.com");
		Assert.assertNotNull(user);
	}

	//@Test
	public void testfindUserByEmail_Negative() {
		User user = userRepository.findUserByEmail("xyz@gmail.com");
		Assert.assertNull(user);
	}

	//@Test
	public void testRegisterNewUserAccount() {
		User user = new User();
		user.setEmail("fatima@gmail.com");
		user.setPassword("secret");
		user.setUserName("aatika");
		user.setEnabled(true);
		Collection<Role> roles = Arrays.asList(roleRepository.findRoleByName("ROLE_USER"),
				roleRepository.findRoleByName("ROLE_ADMIN"));
		user.setRoles(roles);
		user = userRepository.registerNewUserAccount(user);
		Assert.assertNotNull(user.getId());
 	}

	@Test
	public void testValidateUser(){
		boolean result = userRepository.validateUser("aatika", "aatika08");
		Assert.assertEquals(true, result);
	}
}