package com.slend.rest.api.borrower;

import static org.junit.Assert.assertEquals;

import javax.servlet.annotation.WebInitParam;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slend.entity.SpringBootJerseyApplication;
import com.slend.entity.core.borrower.AboutProperty;
import com.slend.entity.core.borrower.ConsumerLoan;
import com.slend.entity.core.borrower.HomeLoan;
import com.slend.entity.core.borrower.PropertyType;
import com.slend.entity.dao.core.borrower.ConsumerLoanDao;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = { SpringBootJerseyApplication.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class HomeLoanTest {
	@Value("${server.port}")
	int port;
	private TestRestTemplate restTemplate;
	ObjectMapper objectMapper;

	@Autowired
	ConsumerLoanDao consumerLoanDao;

	@Before
	public void setup() {
		restTemplate = new TestRestTemplate();
		objectMapper = new ObjectMapper();
		// MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void b_testGetHomeLoanRequestDetails_then_status_OK() {
		String url = "http://localhost:"+port+"/consumerloan/homeloan/gethomeques/1";
		ResponseEntity<ConsumerLoan> entity = restTemplate.getForEntity("http://localhost:8081/consumerloan/homeloan/gethomeques/1", ConsumerLoan.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());

	}

	@Test
	public void a_testCreateHomeLoanApplication_then_status_OK() {
		try {
			HomeLoan obj = new HomeLoan();
			obj.setAboutProperty(AboutProperty.PURCHASE);
			obj.setPropertyType(PropertyType.READY);
			obj.setBuilderName("Aatika");
			obj.setHomeCost("25,00,000");
			obj.setConstructionCost("10,00,000");
			obj.setPlotCost("10,00,000");
			
			 
			ResponseEntity<ConsumerLoan> entity = restTemplate
					.postForEntity("http://localhost:"+port+"/consumerloan/homeloan/create", obj, ConsumerLoan.class);
			assertEquals(HttpStatus.OK, entity.getStatusCode());

		/*	String url = "http://localhost:8081/consumerloan/homeloan/gethomeques/1";
			ResponseEntity<ConsumerLoan> entity1 = restTemplate.getForEntity(url, ConsumerLoan.class);
			assertEquals(HttpStatus.OK, entity1.getStatusCode());*/
		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
