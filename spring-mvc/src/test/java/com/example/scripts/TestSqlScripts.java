package com.example.scripts;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.persistence.model.Role;
import com.example.persistence.repository.IRoleRepository;

@ContextConfiguration(locations = "classpath:config/repository/repository-beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSqlScripts {
	@Autowired
	IRoleRepository roleRepository; 
	
	@Test
	@Sql({"classpath:scripts/data.sql"})
	public void testScripts(){
		Role role = roleRepository.findRoleByName("ROLE_USER");
		assertNotNull(role);
	}
 
}
