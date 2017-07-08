package com.example.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.persistence.model.User;
import com.example.persistence.model.VerificationToken;
import com.example.service.IUserService;
import com.example.service.exceptions.UserAlreadyExistException;
import com.example.service.exceptions.UserDoesNotExistException;
import com.example.service.security.ISecurityService;
import com.example.web.dto.GenericResponse;
import com.example.web.dto.UserDto;
import com.example.web.events.RegistrationCompleteEvent;
import com.example.web.events.RegistrationMailSender;

@Controller
public class RegistrationController {
	@Autowired
	ApplicationEventPublisher eventPublisher;

	@Autowired
	MessageSource messageSource;
	@Autowired
	IUserService userService;
	@Autowired
	RegistrationMailSender registrationMailSender;
	@Autowired
	ISecurityService securityService;
	@RequestMapping(value = "/registerUser.htm", method = RequestMethod.GET)

	public ModelAndView showRegistrationForm() {
		UserDto userDto = new UserDto();

		ModelAndView mv = new ModelAndView();
		mv.addObject("userDto", userDto);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping(value = "/registerUser.htm", method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse createUserAccount(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult result,
			WebRequest request, Errors erros) {
		System.out.println(userDto);
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			System.out.println(errors);
		}
		User user = createUserAccount(userDto);
		if (user != null) {

			eventPublisher
					.publishEvent(new RegistrationCompleteEvent(request.getContextPath(), request.getLocale(), user));
			return new GenericResponse("success");
		}
		if (user == null) {
			result.rejectValue("email", "message.regError");
		}

		return new GenericResponse("failure");
	}

	private User createUserAccount(UserDto userDto) {
		User registeredUser = null;
		try {
			registeredUser = userService.registerNewUserCount(userDto);

		} catch (UserAlreadyExistException e) {
			e.printStackTrace();
			return null;
		}
		return registeredUser;
	}

	@RequestMapping(value = "/testJQuery.htm", method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse testJquery(@RequestParam(value = "email", required = false) String email) {
		System.out.println("email = " + email);
		return new GenericResponse("success");
	}

	@RequestMapping(value = "/registrationConfirmation.htm", method = RequestMethod.GET)
	public String confirmRegistration(WebRequest request, Model model, @RequestParam(value = "token") String token) {
		System.out.println("Registration Confirmation");
		Locale locale = request.getLocale();
		VerificationToken verificationToken = userService.getVerificationToken(token);
		
		Calendar calendar = Calendar.getInstance();
		if (verificationToken != null
				&& ((verificationToken.getExpiryDate().getTime() - calendar.getTime().getTime()) <= 0)) {
			String messageValue = messageSource.getMessage("auth.message.expired", null, locale);
			model.addAttribute("expired", messageValue);
			model.addAttribute("token", token);

			return "redirect:/authentication/badUser?lang=" + locale.getLanguage();
			//return "redirect:resendRegistrationToken.htm";
		}

		userService.updateUserConfirmation(verificationToken.getUser());
		model.addAttribute("message", messageSource.getMessage("message.accountVerified", null, locale));
		return "success";
	}

	@RequestMapping(value = "/resendRegistrationToken.htm", method = RequestMethod.GET)
	public ModelAndView resendRegistrationTokenEmail(HttpServletRequest request,
			@RequestParam("token") String existingToken) {
		System.out.println("Existing token = " + existingToken);
		VerificationToken verificationToken = userService.generateNewVerficationToken(existingToken);
		registrationMailSender.confirmRegistration(request.getLocale(), verificationToken.getToken(),
				verificationToken.getUser());
		System.out.println("Resend Registration Token Email");
		return new ModelAndView("authentication/badUser", "message",
				messageSource.getMessage("message.resendToken", null, null, request.getLocale()));
	}

	@RequestMapping(value = "/resendRegistrationEmail.htm", method = RequestMethod.POST)
	public ModelAndView resendRegistrationEmail(HttpServletRequest request, @RequestParam("email") String email) {
		System.out.println("Resend Registration Email");
		userService.resendRegistrationToken(email);
		return new ModelAndView("error/resendToken", "message", "sent");
	}

	@RequestMapping(value = "/validateUser.htm", method = RequestMethod.POST)
	public ModelAndView validateUser(@RequestParam("j_username") String username,
			@RequestParam("j_password") String password) {
		boolean result = userService.validateUser(username, password);
		if (result == true) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("success");
		}
		return new ModelAndView("failure");
	}

	@RequestMapping(value="/resetPassword.htm", method=RequestMethod.POST)
	@ResponseBody
	public GenericResponse resetPassword(HttpServletRequest request, @RequestParam("email") String email) {
		User user = userService.findUserByEmail(email);
		if (user == null)
			throw new UserDoesNotExistException();
		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);
		registrationMailSender.passwordResetEmail(request.getLocale(), token, user);
		return new GenericResponse(messageSource.getMessage("message.resetPasswordEmail", null, request.getLocale()));
	}
	
	@RequestMapping(value = "/changePassword.htm", method = RequestMethod.GET)
	public ModelAndView showChangePasswordPage(Locale locale, Model model, 
	@RequestParam("id")long id, @RequestParam("token")String token ){
		String result = securityService.validatePasswordResetToken(id, token);
		if(result != null ){
			String message = messageSource.getMessage("auth.message."+result, null, locale);
			model.addAttribute("message", message);
			model.addAttribute("lang", locale.getLanguage());
			return new ModelAndView("redirect:/main.htm");
		}
		System.out.println("Change");
		model.addAttribute("message","changePassword");
		 return new ModelAndView("redirect:/authentication/updatePassword");
 	}
	
	@RequestMapping(value="/savePassword.htm", method=RequestMethod.POST)
	@ResponseBody
	public GenericResponse savePassword(@RequestParam("password")String password){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("user = "+user.getEmail());
		System.out.println("user name  ="+user.getUserName());
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
 		return new GenericResponse("success");
	}
 
}
