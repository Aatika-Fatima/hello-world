package com.slend.rest.api.borrower;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slend.entity.SpringBootJerseyApplication;
import com.slend.entity.core.borrower.CarLoan;

/*@RunWith(SpringRunner.class)
@SpringBootConfiguration()
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ComponentScan(basePackages="com.slend")*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = { SpringBootJerseyApplication.class })
// @SpringBootConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarLoanServiceTest {
	@Value("${server.port}")
	int port;
	private TestRestTemplate restTemplate;
	ObjectMapper objectMapper;

	@Before
	public void setup() {
		restTemplate = new TestRestTemplate();
		objectMapper = new ObjectMapper();
		// MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void b_testGetCarLoanRequestDetails_then_status_OK() {
		String url = "http://localhost:"+port+"/consumerloan/autoloan/carloan/getcardetails/1";
		ResponseEntity<Response> entity = restTemplate.getForEntity(url, Response.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());

	}

	@Test
	@Transactional
	public void a_testCreateCarLoanApplication_then_status_OK() {
		try {
			CarLoan obj = objectMapper.readValue(new File("src/test/resources/json_test_data/carLoan.json"),
					CarLoan.class);

			ResponseEntity<Response> entity = restTemplate
					.postForEntity("http://localhost:"+port+"/consumerloan/autoloan/carloan/create", obj, Response.class);
			assertEquals(HttpStatus.OK, entity.getStatusCode());

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
