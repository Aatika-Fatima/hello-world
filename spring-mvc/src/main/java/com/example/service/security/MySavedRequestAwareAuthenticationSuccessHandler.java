package com.example.service.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
@Component
public class MySavedRequestAwareAuthenticationSuccessHandler extends 
	SimpleUrlAuthenticationSuccessHandler{
	private RequestCache requestCache = new HttpSessionRequestCache();

	public RequestCache getRequestCache() {
		return requestCache;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	     SavedRequest savedRequest
         = requestCache.getRequest(request, response);

	     response.setHeader("targetUrl", determineTargetUrl(authentication));
       if (savedRequest == null) {
           clearAuthenticationAttributes(request);
           return;
       }
       String targetUrlParam = getTargetUrlParameter();
       if (isAlwaysUseDefaultTargetUrl()
         || (targetUrlParam != null
         && StringUtils.hasText(request.getParameter(targetUrlParam)))) {
           requestCache.removeRequest(request, response);
           clearAuthenticationAttributes(request);
           return;
       }

       clearAuthenticationAttributes(request);
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

		if (isUser) {
			return "/spring-mvc/jk";
		} else if (isAdmin) {
			return "/spring-mvc/admin/adminHome.htm";
		} else {
			throw new IllegalStateException();
		}
	}
	
}
