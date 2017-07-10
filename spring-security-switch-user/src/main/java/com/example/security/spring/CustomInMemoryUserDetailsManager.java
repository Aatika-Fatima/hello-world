package com.example.security.spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.web.model.AppUser;

public class CustomInMemoryUserDetailsManager implements UserDetailsService {
	private Map<String, AppUser> users = new HashMap<String, AppUser>();

	public CustomInMemoryUserDetailsManager(Collection<AppUser> users) {
		for (AppUser user : users) {
			this.users.put(user.getUsername().toLowerCase(), user);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		 AppUser user = users.get(userName.toLowerCase());
		 if(user == null )
			 throw new UsernameNotFoundException("Username doesnot exist exception");
		 
		 AppUser userNew = new AppUser(user.getUsername(), user.getPassword(), user.getAuthorities(),
				 user.getLastName(), user.getAge());
		return userNew;
	}

}
