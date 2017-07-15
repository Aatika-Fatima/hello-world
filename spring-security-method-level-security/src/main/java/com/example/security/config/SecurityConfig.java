package com.example.security.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

import com.example.security.spring.CustomInMemoryUserDetailsManager;
import com.example.security.spring.CustomWebSecurityExpressionHandler;
import com.security.web.model.AppUser;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	UserDetailsManager userDetailsManager;
	AppUser admin, user, guest;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().accessDecisionManager(accessDecisionManager());
 		http.authorizeRequests().antMatchers("/css/**", "/login", "/logout", "/webjars/**").permitAll();

		http.authorizeRequests().antMatchers("/home", "/main").fullyAuthenticated().

				antMatchers("/movies/adult/**/*").hasAuthority("ROLE_GUEST")

				.antMatchers("/admin/**/*").hasAuthority("ROLE_ADMIN")

				.and().formLogin().loginPage("/login").defaultSuccessUrl("/home").loginProcessingUrl("/login")
				.failureUrl("/login?error=error").usernameParameter("username").passwordParameter("password")

				.and().rememberMe().rememberMeCookieName("remember-me").tokenValiditySeconds(24 * 60 * 60)
 
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true)
				.deleteCookies("JSESSIONID").and().addFilter(digestAuthenticationFilter());

	}

	@Bean
	public CustomInMemoryUserDetailsManager customInMemoryUserDetailsManager() {
		SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
		SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority("ROLE_USER");
		SimpleGrantedAuthority guestAuthority = new SimpleGrantedAuthority("ROLE_GUEST");

		Collection<? extends GrantedAuthority> adminAuthorities = Arrays.asList(adminAuthority);
		Collection<? extends GrantedAuthority> userAuthorities = Arrays.asList(userAuthority);
		Collection<? extends GrantedAuthority> guestAuthorities = Arrays.asList(guestAuthority);

		admin = new AppUser("aatika", "fatima", adminAuthorities, "Fatima", 20);
		user = new AppUser("aaliya", "fatima", userAuthorities, "Fatima", 12);
		guest = new AppUser("huma", "fatima", guestAuthorities, "Fatima", 20);
		System.err.println(admin.getUsername() + " ====================== " + admin.getAge());
		System.err.println(user.getUsername() + " ====================== " + user.getAge());
		System.err.println(guest.getUsername() + " ====================== " + guest.getAge());

		CustomInMemoryUserDetailsManager cc = new CustomInMemoryUserDetailsManager(Arrays.asList(admin, user, guest));

		return cc;
	}

	@Bean
	public RoleHierarchy roleHierarchy() {
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		roleHierarchy.setHierarchy("ROLE_ADMIN>ROLE_USER ROLE_USER>ROLE_GUEST");
		return roleHierarchy;
	}

	@Bean
	public RoleHierarchyVoter roleHierarchyVoter() {

		return new RoleHierarchyVoter(roleHierarchy());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customInMemoryUserDetailsManager());
	}

	// @Bean
	public CustomWebSecurityExpressionHandler customWebSecurityExpressionHandler() {
		CustomWebSecurityExpressionHandler customWebSecurityExpressionHandler = new CustomWebSecurityExpressionHandler();
		customWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchy());
		return customWebSecurityExpressionHandler;
	}

	@Bean
	public AccessDecisionManager accessDecisionManager() {
		WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
		webExpressionVoter.setExpressionHandler(webExpressionHandler());

		List<AccessDecisionVoter<? extends Object>> decisionVoters = new ArrayList<>();
		decisionVoters.add(roleHierarchyVoter());
		decisionVoters.add(webExpressionVoter);
 		return new AffirmativeBased(decisionVoters);
	}

	@Bean
	public DigestAuthenticationEntryPoint digestAuthenticationEntryPoint() {
		DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new DigestAuthenticationEntryPoint();
		digestAuthenticationEntryPoint.setKey("secretKey!@#");
		digestAuthenticationEntryPoint.setRealmName("Digest Authentication Realm");
		return digestAuthenticationEntryPoint;
	}

	@Bean
	public SecurityExpressionHandler<FilterInvocation> webExpressionHandler() {
		DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
		defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchy());
		return defaultWebSecurityExpressionHandler;
	}

	public DigestAuthenticationFilter digestAuthenticationFilter() {
		DigestAuthenticationFilter digestAuthentiationFilter = new DigestAuthenticationFilter();
		digestAuthentiationFilter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint());
		return digestAuthentiationFilter;
	}
}
