package com.example.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyUtils;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableWebSecurity(debug = true)
@EnableTransactionManagement
public class SpringSecurityFormBasedLoginApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
	//	SpringApplication.run(SpringSecurityFormBasedLoginApplication.class, args);
		RoleHierarchy roleHierarchy = SpringApplication.run(SpringSecurityFormBasedLoginApplication.class, args)
				.getBean(RoleHierarchy.class);
		
		SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_USER");
		

		Collection<? extends GrantedAuthority> adminAuthorities = Arrays.asList(adminAuthority);
		
		Collection<? extends GrantedAuthority> x=  roleHierarchy.getReachableGrantedAuthorities(adminAuthorities);
		System.err.println("**************************");
		for(GrantedAuthority value: x){
			System.err.println(value.getAuthority());
		}
		System.err.println("**************************");
		System.err.println("**************************");
		
		 
	}

 
}
