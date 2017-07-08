package com.example.config;

 
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/service/email-properties.xml"})
@TestPropertySource(locations={"classpath:config/properties/mail.properties", "classpath:config/properties/application.properties"})
public class TestPropertyConfigFiles {

	@Autowired
	Environment environment;
 
	@Test
	public void testMailConfigProperties(){
		Assert.assertEquals("587", environment.getProperty("smtp.port"));
		Assert.assertEquals("csenotes123@gmail.com", environment.getProperty("support.email"));
		Assert.assertEquals("smtp.gmail.com", environment.getProperty("smtp.host"));
		Assert.assertEquals("smtps", environment.getProperty("spring.mail.protocol"));
		Assert.assertEquals("csenotes123@gmail.com", environment.getProperty("smtp.username"));
	 
	}
	@Test
	public void testApplicationConfigProperties(){
		Assert.assertEquals("http://localhost:8081/spring-mvc", environment.getProperty("server.contextpath"));
		 
	 
	}
}
