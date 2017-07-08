package com.example.repository;

 import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.persistence.model.VerificationToken;
import com.example.persistence.repository.IVerificationTokenRepository;

@ContextConfiguration(locations = "classpath:config/repository-beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TokenRepositoryTest {
 
	
	@Autowired
	IVerificationTokenRepository tokenRepository;
	
	@Test
	public void testfindByToken(){
		String token = "4a4b621f-1e5e-43c8-b237-562e6a82e4c0";
		
		VerificationToken verificationToken = tokenRepository.findByToken(token);
		Assert.assertNotNull(verificationToken);
	}
}
