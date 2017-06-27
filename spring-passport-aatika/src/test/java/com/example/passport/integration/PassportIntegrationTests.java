package com.example.passport.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.example.passport.model.AddressProofDoc;
import com.example.passport.model.ApplicationStatus;
import com.example.passport.model.Gender;
import com.example.passport.model.Passport;
import com.example.passport.model.PhotoProofDoc;
import com.example.passport.repository.IPassportRepository;
import com.example.passport.util.FailureMessage;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableSpringDataWebSupport
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PassportIntegrationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	MockHttpServletRequest request;
	@Autowired
	IPassportRepository passportRepository;
	private MockMvc mockMvc;

 
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		/*
		 * request.setParameter("applicationId", "1");
		 * request.setParameter("photoFile",
		 * "http://www.example.com/Aatika.jpeg");
		 * request.setParameter("addressProofDocNumber", "1");
		 * request.setParameter("addressProofDocFile",
		 * "http://www.example.com/Aatika.docx");
		 * request.setParameter("photoIdProofDocNumber", "1");
		 * request.setParameter("photoIdProofDocFile",
		 * "http://www.example.com/Aadhar.jpg");
		 */
		//testCreateApplicationDocument();
	}
	 
	@Test
	@Commit
	public void a_testCreateApplicationDocument() {
		Passport p = new Passport();
		p.setAddress("T.chowki");
		p.setApplicationId(1);
		p.setName("Aatika");
		p.setFatherName("Mohd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1987, 3, 8);
		p.setDateOfBirth(calendar.getTime());
		p.setGender(Gender.FEMALE);
		p.setAddress("Hyd");
		p.setPhone("1234567890");
		p.setEmail("aatika08@gmail.com");
		p.setApplicationStatus(ApplicationStatus.DRAFT);
		p.setAddressProofDoc(AddressProofDoc.AADHAAR);
		p.setPhotoIdProofDoc(PhotoProofDoc.DRIVING_LICENSE);
		p.setPhotoURL("http://www.example.com/asdf.jpg");

		p.setAddressProofDocNumber("1");
		p.setAddressProofDocFileUrl("http://www.example.com/AddressProof.doc");

		p.setPhotoIdProofDocNumber(1);
		p.setPhotoIdProofDocUrl("http://www.example.com/photoURL.docx");
		p.setLastModified(Calendar.getInstance().getTime());

		passportRepository.create(p);
	}

	@Test
	public void test_whenDocumentExist_then_status200() {
		try {

			ResultActions resultActions = mockMvc.perform(get("/passport/getapplication/{applicationId}", 1));

			resultActions.andExpect(status().isOk());
			MvcResult mvcResult = mockMvc.perform(get("/passport/getapplication/{applicationId}", 1)).andReturn();
			mvcResult.equals(passportRepository.findDocumentByApplicationId(1));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test_whenDocumentDoesnotExist_then_status400() {
		ResultActions resultActions;
		try {
			resultActions = mockMvc.perform(get("/passport/getapplication/{applicationId}", -1));
			resultActions.andExpect(status().is(400));
			MvcResult mvcResult = mockMvc.perform(get("/passport/getapplication/{applicationId}", -1)).andReturn();
			FailureMessage failureMessage = new FailureMessage();
			failureMessage.setStatus(0);
			failureMessage.setMessage("An Error occurred while fetching Application " + -1);
			mvcResult.equals(failureMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void test_createPassport_then_SuccessMessage() {
		try {
			mockMvc.perform(get("/passport/create").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
			// .andExpect(content().equals(obj));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
