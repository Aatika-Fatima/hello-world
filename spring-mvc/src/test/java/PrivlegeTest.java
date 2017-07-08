import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.persistence.model.Privlege;
import com.example.persistence.model.Role;
import com.example.persistence.model.User;
 @ContextConfiguration(locations = "classpath:config/repository-beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
 public class PrivlegeTest extends AbstractJUnit4SpringContextTests {
	 
	@Autowired
	SessionFactory sessionFactory;
	Session session;

	@Before
	public void setUp() {
		session = sessionFactory.openSession();
	}

	@After
	public void cleanUp() {
		session.close();
	}

	@Test
	public void testPrivlegeSet() {
		//Session session = factory.openSession();

		Privlege privlege1 = new Privlege();
		privlege1.setName("CREATE_USER");
		Privlege privlege2 = new Privlege();
		privlege2.setName("DELETE_USER");
		Privlege privlege3 = new Privlege();
		privlege3.setName("EDIT_USER");
		Privlege privlege4 = new Privlege();
		privlege4.setName("READ_USER");

		
		Set<Privlege> privlegeSet = new HashSet<>();
		privlegeSet.add(privlege1);
		privlegeSet.add(privlege2);
		privlegeSet.add(privlege3);
		privlegeSet.add(privlege4);

 		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleAdmin.setPrivleges(privlegeSet);
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleUser.setPrivleges(Arrays.asList(privlege4));
		
		User user = new User();
		user.setUserName("Aatika");
		user.setPassword("secret");
		user.setEmail("aatika@gmail.com");
		user.setEnabled(true);
		
		user.setRoles(Arrays.asList(roleAdmin));
		
		session.getTransaction().begin();
		session.saveOrUpdate(privlege1);
		session.flush();
		session.saveOrUpdate(privlege2);
		session.flush();
		session.saveOrUpdate(privlege3);
		session.flush();
		session.saveOrUpdate(privlege4);
		session.flush();

		session.save(roleAdmin);
		session.flush();
		
 		session.save(roleUser);
 		session.flush();
 		
 		
 		session.save(user);
		session.flush();
		System.out.println("Saved");
		session.getTransaction().commit();
	}
}
