package com.example.service.exceptions;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.web.dto.GenericResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

//	@ExceptionHandler({ UsernameNotFoundException.class })
	public ResponseEntity<Object> handleUserNotFound(RuntimeException ex, WebRequest request) {
		GenericResponse bodyOfResponse = new GenericResponse(
				messageSource.getMessage("message.userNotFound", null, request.getLocale()), "UserNotFound");
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({ MailAuthenticationException.class })
	public ResponseEntity<Object> handleEmail(RuntimeException ex, WebRequest request) {
		String message = messageSource.getMessage("message.email.config.error", null, request.getLocale());

		GenericResponse bodyOfResponse = new GenericResponse(message, "Mail Error");

		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleInternal(RuntimeException ex, WebRequest request) {
		logger.error("500 Status Code", ex);
		GenericResponse bodyOfResponse = new GenericResponse(
				messageSource.getMessage("message.error", null, request.getLocale()), "InternalError");

		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({ TokenDoesNotExistException.class })
	public ModelAndView handleTokenDoesNotExistException(HttpServletRequest request) {
		Locale locale = request.getLocale();
		ModelAndView mv = new ModelAndView("error/resendToken");
		String message = messageSource.getMessage("auth.message.invalidToken", null, request.getLocale());
		mv.addObject("message", "invalid token");
		//return "redirect:/authentication/badUser?lang=" + locale.getLanguage();
		return mv;
	}
	
	@ExceptionHandler({EmailDoesNotExistException.class})
	public ModelAndView handleEmailDoesNotExistException(EmailDoesNotExistException e){
		return new ModelAndView("error/resendToken","message", e.getMessage());
	}
	
	@ExceptionHandler({CategoryExistsException.class})
	public ModelAndView handleCategoryExistsException(CategoryExistsException c){
		System.out.println("ex "+c.getMessage());
		return new ModelAndView("admin/test/category","message", "failure");
	}
}
