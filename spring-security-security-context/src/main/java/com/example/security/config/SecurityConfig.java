package com.example.security.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

import com.example.security.spring.CustomInMemoryUserDetailsManager;
import com.example.security.spring.CustomWebSecurityExpressionHandler;
import com.security.web.model.AppUser;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	UserDetailsManager userDetailsManager;
	AppUser admin, user, guest;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().accessDecisionManager(accessDecisionManager());
		http.csrf().disable().authorizeRequests().expressionHandler(customWebSecurityExpressionHandler())
				.antMatchers("/css/**", "/login", "/webjars/**").permitAll().antMatchers("/", "/home", "/main", "/logout")
				.authenticated()

				.antMatchers("/admin/dashboard").fullyAuthenticated().antMatchers("/admin/dashboard")
				.hasAuthority("ADMIN")

				.antMatchers("/admin/movies")
				.access("hasAuthority('ADMIN') and hasAgeOver18() and hasAuthority('IS_FULLY_AUTHENTICATED')")

				.and().formLogin().loginPage("/login").defaultSuccessUrl("/home").loginProcessingUrl("/login")
				.failureUrl("/login?error=error").usernameParameter("username").passwordParameter("password").permitAll()

				.and().rememberMe().rememberMeCookieName("remember-me").tokenValiditySeconds(24 * 60 * 60)

 
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true)
				.deleteCookies("JSESSIONID").permitAll()

				.and().addFilter(digestAuthenticationFilter());

	}

	@Bean
	public CustomInMemoryUserDetailsManager customInMemoryUserDetailsManager() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ADMIN");
		Collection<? extends GrantedAuthority> authorities = Arrays.asList(simpleGrantedAuthority);
		admin = new AppUser("aatika", "fatima", authorities, "Fatima", 12);
		System.err.println(admin.getUsername() + " ====================== " + admin.getAge());

		
		CustomInMemoryUserDetailsManager cc = new CustomInMemoryUserDetailsManager(Arrays.asList(admin));

		return cc;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customInMemoryUserDetailsManager());
	}

	@Bean
	public CustomWebSecurityExpressionHandler customWebSecurityExpressionHandler() {
		return new CustomWebSecurityExpressionHandler();
	}
 

	@Bean
	public AccessDecisionManager accessDecisionManager() {
		WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
		webExpressionVoter.setExpressionHandler(customWebSecurityExpressionHandler());
		List<AccessDecisionVoter<? extends Object>> decisionVoters =
				Arrays.asList(
				webExpressionVoter, new RoleVoter(),
				new AuthenticatedVoter());
		return new UnanimousBased(decisionVoters);
	}

	@Bean
	public DigestAuthenticationEntryPoint digestAuthenticationEntryPoint() {
		DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new DigestAuthenticationEntryPoint();
		digestAuthenticationEntryPoint.setKey("secretKey!@#");
		digestAuthenticationEntryPoint.setRealmName("Digest Authentication Realm");
		return digestAuthenticationEntryPoint;
	}

	public DigestAuthenticationFilter digestAuthenticationFilter() {
		DigestAuthenticationFilter digestAuthentiationFilter = new DigestAuthenticationFilter();
		digestAuthentiationFilter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint());
		return digestAuthentiationFilter;
	}
}
