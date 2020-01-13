package com.epam.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.entity.MyUsers;
import com.epam.repository.UserRepository;

@Service
public class UserServicesImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUsers currentUser = userRepository.findByUsername(username);
		if (currentUser != null) {
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_" + currentUser.getRole());
			return new User(currentUser.getUsername(), currentUser.getPassword(), grantedAuthorities);
		}
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}

}
