package com.example.repository;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.persistence.model.Privlege;
import com.example.persistence.model.Role;
import com.example.persistence.repository.IPrivlegeRepository;
import com.example.persistence.repository.IRoleRepository;

  
 
@ContextConfiguration(locations = "classpath:config/repository/repository-beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleRepositoryTest {
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	
	@Autowired
	IRoleRepository roleRepository;
 
	@Before
	public void setUp(){
		session = sessionFactory.openSession();
	}
	@After
	public void tearDown(){
		//sessionFactory.close();
	}
 	
//	@Test
	public void testFindUserByEmail(){
		Role role = roleRepository.findRoleByName("ROLE_USER");
		assertNotNull(role);
	}
 
	@Test
	public void testfindRoleByPrivleges(){
		List<String> privlegeList = new ArrayList<>();
/*		insert into privlege values( 1, 'CREATE_USER') ;
		insert into privlege values( 2, 'DELETE_USER') ;
		insert into privlege values( 3, 'EDIT_USER') ;
		insert into privlege values( 4, 'READ_USER') ;
		insert into privlege values( 5, 'CHANGE_PASSWORD_PRIVILEGE') ;*/
		Privlege p1 = new Privlege();p1.setId(1);p1.setName("CREATE_USER");
		Privlege p2 = new Privlege();p2.setId(2);p2.setName("DELETE_USER");
		Privlege p3 = new Privlege();p3.setId(3);p3.setName("EDIT_USER");
		Privlege p4 = new Privlege();p4.setId(4);p4.setName("READ_USER");
		Privlege p5 = new Privlege();p5.setId(5);p5.setName("CHANGE_PASSWORD_PRIVILEGE");
/*		privlegeList.add(p1);privlegeList.add(p2);privlegeList.add(p3);
		privlegeList.add(p4);privlegeList.add(p5);*/
		privlegeList.add("CREATE_USER");privlegeList.add("DELETE_USER");privlegeList.add("EDIT_USER");
		privlegeList.add("READ_USER");privlegeList.add("CHANGE_PASSWORD_PRIVILEGE");
		List<Role> roles = roleRepository.findRoleByPrivleges(privlegeList);
	 
	}
 
	
}
