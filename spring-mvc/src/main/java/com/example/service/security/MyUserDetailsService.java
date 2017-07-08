package com.example.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.persistence.model.Privlege;
import com.example.persistence.model.Role;
import com.example.persistence.model.User;
import com.example.persistence.repository.IUserRepository;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	LoginAttemptService loginAttemptService;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	HttpServletRequest request;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String ip = getClientIp();
		if (loginAttemptService.isBlocked(ip)) {
			System.out.println("blocked -- " + ip);
			throw new RuntimeException("blocked");
		}

		if (userRepository == null) {
			System.out.println("User Repository is null");
		}
		User user = userRepository.findUserByEmail(username);
		if (user == null) {
			System.out.println("username does not exist " +username);
			throw new UsernameNotFoundException("username doesnot exist");
		}
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		Collection<Role> roles = user.getRoles();
/*		System.out.println("MyUserDetails Service method----------->");

		for (Role role : roles) {
			System.out.println("Roles = " + role.getId() + " " + role.getName());
			Collection<Privlege> privleges = role.getPrivleges();
			for (Privlege p : privleges) {
				System.out.println("Privlege \t" + p.getName());
			}
		}*/

		Collection<? extends GrantedAuthority> authorities = getAuthorities(user.getRoles());
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				user.isEnabled(), accountNonExpired, credentialsNonExpired, accountNonLocked,
				getAuthorities(user.getRoles()));
	}

	public final Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
		return getGrantedAuthorities(getPrivileges(roles));

	}

	private final List<String> getPrivileges(final Collection<Role> roles) {
		final List<String> privlegeNames = new ArrayList<>();
		final List<Privlege> privleges = new ArrayList<>();
		for (final Role role : roles) {
			privleges.addAll(role.getPrivleges());
		}
		for (Privlege p : privleges) {
			privlegeNames.add(p.getName());
		}
		return privlegeNames;
	}

	private List<GrantedAuthority> getGrantedAuthorities(final List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String role : roles) {
			System.out.println("ROLE==" + role);
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	private String getClientIp() {
		String xfHeader = request.getHeader("X-Forwaded-For");
		if (xfHeader == null) {
			return request.getRemoteAddr();

		}
		return xfHeader.split(",")[0];

	}
}
