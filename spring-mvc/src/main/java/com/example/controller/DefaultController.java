package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

 

	@RequestMapping(value = { "/main.htm", "/ logout.htm" })
	public String main() {
		System.out.println("Main method");
		return "main";
	}
	
	@RequestMapping(value = { "/mainPage.htm"})
	public String loadMainPage(){
		return "main";
	}

	@RequestMapping("/createQuesiton.htm")
	public String createQuestion(){
		return "admin/test/createQuestion";
	}
	@RequestMapping("/login.htm")
	public String login() {
		System.out.println("Login method");
		return "login";
	}

	@RequestMapping("/editQuestion.htm")
	public String editQuestion() {
		return "admin/test/editQuestion";
	}

	@RequestMapping("/questionBank.htm")
	public String questionBank() {
		return "admin/test/questionBank";
	}

	@RequestMapping("/settings.htm")
	public String settings() {
		return "admin/test/settings";
	}

	@RequestMapping("/testProperties.htm")
	public String testProperties() {
		return "admin/test/testProperties";
	}

	@RequestMapping("/loginFailed.htm")
	public String loginFailed() {
		return "login";
	}

	@RequestMapping("/admin/adminHome.htm")
	public String adminHomePage() {
		return "admin/test/adminHome";
	}

	@RequestMapping("/403.htm")

	public String errorPage() {
		return "error/403";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') and hasPermission(#name, 'createUser')")
	@RequestMapping(value="/category.htm",method=RequestMethod.GET)
	public String addCategory(@ModelAttribute("name") String name){
		return "admin/test/questionBank";
	}
}
