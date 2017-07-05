package com.accenture.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable()
		 .authorizeRequests().antMatchers("/css/**","/login").permitAll()
		 .antMatchers("/","/home","/main","/logout").authenticated()
		
		 .and()
		 
		 .formLogin()
		 .loginPage("/login")
		 .defaultSuccessUrl("/home")
		 .loginProcessingUrl("/login")
		 .failureUrl("/login?error=error")
		 .usernameParameter("username")
		 .passwordParameter("password")
		 
		 .and()
		 
		 .logout()
		 .logoutUrl("/logout")
		 .logoutSuccessUrl("/login?logout=true")
		 .invalidateHttpSession(true)
		 .deleteCookies("JSESSIONID")
		 ;
		 
		 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication().withUser("aatika").password("fatima")
		 .authorities("USER");
		  
	}
}
