package com.example.service.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
 
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		System.out.println("Custom logout");
			final HttpSession session = request.getSession( );
			if(session != null){
				Enumeration<String> attNames = session.getAttributeNames();
				while(attNames.hasMoreElements()){
					session.removeAttribute(attNames.nextElement());
				}
				session.invalidate();
				response.sendRedirect("main.htm?logSuccess=true");
			}
	}

}
