package com.crmproject.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crmproject.models.User;
import com.crmproject.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<List<User>> users = userRepository.findAllByUsername(username);
		Optional<User> user = users.get().stream().findAny();
		
		user.orElseThrow(() -> 
			new UsernameNotFoundException (username + "not found.")
		);
		
		return user.map(UserDetailsImpl::new).get();
		
	}
}
