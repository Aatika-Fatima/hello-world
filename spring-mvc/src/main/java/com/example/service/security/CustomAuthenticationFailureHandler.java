package com.example.service.security;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.servlet.LocaleResolver;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	private MessageSource messageResource;

	@Autowired
	private LocaleResolver localeResolver;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// setDefaultFailureUrl("/main?error=true");
		// response.setStatus(HttpStatus.);
		// super.onAuthenticationFailure(request, response, exception);

		Locale locale = localeResolver.resolveLocale(request);

		System.out.println("********************************************");
		System.out.println(exception.getMessage() + " " + locale.getLanguage() + "_" + locale.getCountry());
		System.out.println("********************************************");

		String errorMessage = null;
		if (exception.getMessage().equalsIgnoreCase("blocked")) {
			errorMessage = messageResource.getMessage("auth.message.blocked", null, locale);
		} else if (exception.getMessage().equalsIgnoreCase("User is disabled")) {
			errorMessage = messageResource.getMessage("auth.message.disabled", null, locale);
		} else if (exception.getMessage().equalsIgnoreCase("User account has expired")) {
			errorMessage = messageResource.getMessage("auth.message.expired", null, locale);
		} else {
			errorMessage = messageResource.getMessage("message.badCredentials", null, locale);
		}

		System.out.println(errorMessage);
		HttpSession session = null;
		session = request.getSession();

		/*
		 * HttpSession session = request.getSession(); try{ Exception e=
		 * (Exception)
		 * session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		 * System.out.println(e.getMessage());
		 * session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		 * }catch(NullPointerException npe){ npe.printStackTrace(); }
		 */
		// session.setAttribute("errorMessage", errorMessage);
		session.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, errorMessage);
		System.out.println(session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION));
		System.out.println("********************************************");
		//response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setHeader("errorMessage", errorMessage);
		return;
		//response.getWriter().flush();

		// authenticationFailureHandler.onAuthenticationFailure(request,
		// response, exception);
		// request.setAttribute("errorMessage", errorMessage);

	}

}
