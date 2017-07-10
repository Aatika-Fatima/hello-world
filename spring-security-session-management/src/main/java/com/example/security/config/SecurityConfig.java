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
import org.springframework.security.config.http.SessionCreationPolicy;
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
	UserDetails admin, user1, user2;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().expressionHandler(customWebSecurityExpressionHandler())

				.antMatchers("/css/**", "/login").permitAll().antMatchers("/", "/home", "/main", "/logout")
				.authenticated()

				.antMatchers("/admin/dashboard").fullyAuthenticated().antMatchers("/admin/dashboard")
				.hasAuthority("ADMIN")

				.antMatchers("/admin/movies").fullyAuthenticated().antMatchers("/admin/movies")
				.access("hasAuthority('ADMIN') and hasAgeOver18()").accessDecisionManager(accessDecisionManager())
				// .antMatchers("/admin/movies").hasAuthority("ADMIN").accessDecisionManager(accessDecisionManager())

				.and().formLogin().loginPage("/login").defaultSuccessUrl("/home").loginProcessingUrl("/login")
				.failureUrl("/login?error=error").usernameParameter("username").passwordParameter("password")

				.and().rememberMe().rememberMeCookieName("remember-me").tokenValiditySeconds(24 * 60 * 60)

				// .rememberMe().rememberMeServices(rememberMeServices())

				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")

				.and().addFilter(digestAuthenticationFilter())

		;
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		.maximumSessions(1);

	}

	@Bean
	public CustomInMemoryUserDetailsManager customInMemoryUserDetailsManager() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ADMIN");
		Collection<? extends GrantedAuthority> authorities = Arrays.asList(simpleGrantedAuthority);
		AppUser appUser = new AppUser("aatika", "fatima", authorities, "Fatima", 20);
		System.err.println(appUser.getUsername() + " ====================== " + appUser.getAge());
		CustomInMemoryUserDetailsManager cc = new CustomInMemoryUserDetailsManager(Arrays.asList(appUser));
		return cc;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("aatika").password("fatima").authorities("USER");
		// auth.userDetailsService(userDetailsManager);
		auth.userDetailsService(customInMemoryUserDetailsManager());
	}

	@Bean
	public CustomWebSecurityExpressionHandler customWebSecurityExpressionHandler() {
		return new CustomWebSecurityExpressionHandler();
	}

	@Bean
	public PersistentTokenBasedRememberMeServices rememberMeServices() {
		admin = new User("aatika", "fatima", Arrays.asList(new SimpleGrantedAuthority("USER"),
				new SimpleGrantedAuthority("readonly"), new SimpleGrantedAuthority("readwrite")));

		user1 = new User("aaliya", "fatima",
				Arrays.asList(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("readwrite")));

		UserDetails user2 = new User("humaira", "fatima", Arrays.asList(new SimpleGrantedAuthority("USER")));

		userDetailsManager = new InMemoryUserDetailsManager(Arrays.asList(admin, user1, user2));

		PersistentTokenBasedRememberMeServices rememberMeServices = new PersistentTokenBasedRememberMeServices("secret",
				userDetailsManager, new InMemoryTokenRepositoryImpl());
		rememberMeServices.setTokenValiditySeconds(60 * 60 * 24);

		return rememberMeServices;
	}

	@Bean
	public AccessDecisionManager accessDecisionManager() {
		WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
		webExpressionVoter.setExpressionHandler(customWebSecurityExpressionHandler());
		List<AccessDecisionVoter<? extends Object>> decisionVoters = Arrays.asList(webExpressionVoter, new RoleVoter(),
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
