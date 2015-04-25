package com.monarchfan.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.monarchfan.repository.UserRepository;
import com.monarhfan.model.UserRole;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {
		try {
			System.out.println("here here here");
			System.out.println("Username:" + username);

			com.monarhfan.model.User user = userRepository
					.getUserbyUserName(username);

			System.out.println("here here here");
			if (user == null) {
				throw new UsernameNotFoundException("User not found");
			}

			List<GrantedAuthority> authorities = buildUserAuthority(user
					.getRole());

			return buildUserForAuthentication(user, authorities);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			throw new UsernameNotFoundException(e.toString());
		}

	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.monarhfan.model.User user,
			List<GrantedAuthority> authorities) {
		return new User(user.getUserName(), user.getPassword(), true, true,
				true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(UserRole userRoles) {

		if (userRoles == null) {
			System.out.println("User Roles is null");
		}

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities

		setAuths.add(new SimpleGrantedAuthority(userRoles.getUserRole()));

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);

		return Result;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
