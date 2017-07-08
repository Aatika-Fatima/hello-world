package com.example.service.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.persistence.model.Role;
import com.example.persistence.repository.IRoleRepository;

@Component
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
 
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Autowired
	IRoleRepository roleRepository;

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if (authentication == null) {
			System.out.println("Authentication object is null");
		}
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			System.out.println("Response is already committed unable to redirect to " + targetUrl);
			return;
		}
		System.out.println("Target url = " + targetUrl);
		if("true".equals("X-Ajax-Call")){
			response.getWriter().print("ok");
			response.getWriter().flush();
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	public void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public String determineTargetUrl(Authentication authentication) {
 		boolean isUser = false;
		boolean isAdmin = false;
		boolean isRegisteredUser = false;
		 
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		System.out.println("Authorities......" + authorities);
		// List<Role> roles = roleRepository.findRoleByPrivleges(authorities);
		List<String> privleges = new ArrayList<>();
		for (GrantedAuthority authority : authorities) {

			// System.out.println("Authority = " + authority.getAuthority());
			privleges.add(authority.getAuthority());
			if (authority.getAuthority().equals("READ_USER")) {
				isUser = true;
				isAdmin = false;
				isRegisteredUser = false;
				break;
			} else if (authority.getAuthority().equals("CREATE_USER")) {

				isAdmin = true;
				isUser = false;
				isRegisteredUser = false;
				break;
			}
		}
	/*	List<Role> roles = roleRepository.findRoleByPrivleges(privleges);
		String URL = null;

		for (Role role : roles) {

			switch (role.getName()) {
			case "ROLE_ADMIN":
				URL = "/adminHome.htm";
				break;
			case "ROLE_REGISTERED_USER":
				URL = "/jk";
				break;
			}
		}*/
		if (isUser) {
			return "/jk";
		} else if (isAdmin) {
			return "/admin/adminHome.htm";
		} else {
			throw new IllegalStateException();
		}
	}

}
