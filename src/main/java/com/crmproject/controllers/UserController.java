package com.crmproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crmproject.models.User;
import com.crmproject.models.UserLogin;
import com.crmproject.models.UserResponse;
import com.crmproject.repository.UserRepository;
import com.crmproject.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok(userRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable long id) {
		return userRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	
	  @GetMapping("/username/{username}") public ResponseEntity<List<User>>
	  getByUsername(@PathVariable String username){ 
		  return ResponseEntity.ok(userRepository.findAllByUsernameContainingIgnoreCase(
	  username)); 
		}
	  
	@PostMapping
	public ResponseEntity<User> post(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
	}

	@PutMapping
	public ResponseEntity<User> put(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		userRepository.deleteById(id);
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication(@RequestBody UserLogin user) {
		return userService.signIn(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity signUp(@RequestBody User user){
		
		UserResponse userResponse = new UserResponse();
		
		
		try {
			user = userService.signUp(user);
		} catch (Exception e) {
			userResponse.setMessage(e.getMessage());
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)		
			.body(userResponse);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED)
		.body(user);
	}

}
