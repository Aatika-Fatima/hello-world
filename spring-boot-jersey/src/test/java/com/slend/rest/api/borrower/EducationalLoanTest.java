package com.slend.rest.api.borrower;

import static org.junit.Assert.assertEquals;

import java.io.File;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slend.entity.SpringBootJerseyApplication;
import com.slend.entity.core.borrower.ApplicantDetails;
import com.slend.entity.core.borrower.ConsumerLoan;
import com.slend.entity.core.borrower.EducationLoan;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = { SpringBootJerseyApplication.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class EducationalLoanTest {
	@Value("${server.port}")
	int port;
	private TestRestTemplate restTemplate;
	 
    ObjectMapper objectMapper ;
	 
    @Before
	public void setUp() {
		restTemplate = new TestRestTemplate();
		objectMapper = new ObjectMapper();
	}

	@Test
	public void b_getCarLoanRequestDetails_then_status_OK() {

		ResponseEntity<ConsumerLoan> entity = 
				restTemplate.getForEntity("http://localhost:"+port+"/consumerloan/educationloan/geteducationques/1", ConsumerLoan.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());

	}

	@Test
	public void a_createApplicantDetails_then_status_OK() {
		try {

			EducationLoan obj = objectMapper.readValue(new File("src/test/resources/json_test_data/educationLoan.json"),
					EducationLoan.class);
			ResponseEntity<ConsumerLoan> entity = restTemplate
					.postForEntity("http://localhost:"+port+"/consumerloan/educationloan/create", obj, ConsumerLoan.class);
			assertEquals(HttpStatus.OK, entity.getStatusCode());


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
