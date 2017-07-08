package com.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Map;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.exceptions.EmailDoesNotExistException;
import com.example.web.dto.UserDto;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:config/web/application-context-test.xml")
@Transactional
public class RegistrationControllerTest {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	@Autowired
	private SessionFactory sessionFactory;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	// @Test
	public void testShowRegistrationForm() {
		try {
			ResultActions resultActions = mockMvc
					.perform(get("/spring-mvc/registerUser.htm").contextPath("/spring-mvc"));
			resultActions.andExpect(status().isOk());
			UserDto userDto = new UserDto();
			resultActions.andExpect(model().attributeExists("userDto"));
			resultActions.andExpect(view().name("main"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void testRegisterNewUser() {
		MockHttpServletRequestBuilder createMessage = post("/registerUser.htm").param("userName", "aatika08@gmail.com")
				.param("password", "secret").param("reEnterPassword", "secret123").param("email", "aatika08@gmail.com");

		try {
			ResultActions resultActions = mockMvc.perform(createMessage);
			resultActions.andExpect(status().isOk());
			MvcResult mvcResult = resultActions.andReturn();
			System.out.println(mvcResult.getHandler());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
	public void testResendRegistrationTokenEmail() {
		MockHttpServletRequestBuilder createMessage = get("/resendRegistrationToken.htm").param("token",
				"4161f4c6-3d9b-4629-8edf-1335c7e43d3f");
		try {
			ResultActions resultActions = mockMvc.perform(createMessage);
			resultActions.andExpect(status().isOk());
			MvcResult mvcResult = resultActions.andReturn();
			ModelAndView mav = mvcResult.getModelAndView();
			MockHttpServletRequest mockRequest = mvcResult.getRequest();
			System.out.println(mockRequest.getLocale().getLanguage());
			ModelAndViewAssert.assertViewName(mav, "authentication/badUser");
			ModelAndViewAssert.assertModelAttributeAvailable(mav, "message");
		} catch (Exception e) {

		}
	}

	//@Test
	public void testResendRegistrationEmail() throws Exception {
		MockHttpServletRequestBuilder createMessage = post("/resendRegistrationEmail.htm").param("email",
				"aatika08@yahoo.com");

		ResultActions resultActions = mockMvc.perform(createMessage);
		resultActions.andExpect(status().isOk());
		MvcResult mvcResult = resultActions.andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		MockHttpServletRequest mockRequest = mvcResult.getRequest();
		ModelAndViewAssert.assertViewName(mav, "error/resendToken");
		ModelAndViewAssert.assertModelAttributeAvailable(mav, "message");
		Map<String, Object> model = mav.getModel();
		System.out.println(model);
		Assert.assertEquals("sent", model.get("message").toString());

	}

	//@Test
	public void testResendRegistrationEmailException() throws Exception {
		MockHttpServletRequestBuilder createMessage = post("/resendRegistrationEmail.htm")
				.param("email",
				"asdf@yahoo.com");

		ResultActions resultActions = mockMvc.perform(createMessage);
		resultActions.andExpect(status().isOk());
		MvcResult mvcResult = resultActions.andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		MockHttpServletRequest mockRequest = mvcResult.getRequest();
		ModelAndViewAssert.assertViewName(mav, "error/resendToken");
		ModelAndViewAssert.assertModelAttributeAvailable(mav, "message");
		Map<String, Object> model = mav.getModel();
		System.out.println(model);
		Assert.assertEquals("Email Does Not Exist", model.get("message").toString());

	}
	
	@Test
	public void testUpdatePassword() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("/updatePassword.htm")
				.param("userId","2")
				.param("newPassword", "secret");
		ResultActions resultActions = mockMvc.perform(createMessage);
		resultActions.andExpect(status().isOk());
		MvcResult mvcResult = resultActions.andReturn();
		ModelAndView mv = mvcResult.getModelAndView();
		String viewName = mv.getViewName();
		Assert.assertEquals("success", viewName);
	}
}
