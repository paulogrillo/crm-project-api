package com.crmproject.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.crmproject.models.User;
import com.crmproject.models.UserLogin;
import com.crmproject.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserDetailsService userDetailsService;

	public User signUp(User user) throws Exception {
		
		Optional<List<User>> users = repository.findAllByUsername(user.getUsername());
		
		if (users.isPresent() && !users.get().isEmpty()) {
			
			throw new Exception("Usuário já cadastrado!");
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String passwordEncoder = encoder.encode(user.getPassword());
		user.setPassword(passwordEncoder);
		return repository.save(user);
	}

	public List<User> userList() {
		return repository.findAll();
	}

	public Optional<UserLogin> signIn(UserLogin userLogin) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional <List<User>> users = repository.findAllByUsername(userLogin.getUsername());
		
		if (users.isPresent()) {
			
			for(User user : users.get()) {
				
				if (encoder.matches(userLogin.getPassword(), user.getPassword())) {

					String auth = userLogin.getUsername() + ":" + userLogin.getPassword();
					byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
					String authHeader = "Basic " + new String(encodeAuth);
					
					
					userLogin.setToken(authHeader);
					userLogin.setId(user.getId());
					userLogin.setUsername(user.getUsername());
					
					UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
					userLogin.setDetails(userDetails);

					return Optional.ofNullable(userLogin);
				}
				
			}
			

		}
		return null;
	}

	
}
