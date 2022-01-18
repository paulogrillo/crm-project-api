package com.crmproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crmproject.models.Client;
import com.crmproject.repository.ClientRepository;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientController {

	@Autowired
	private ClientRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Client>>getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/client/{nameClient}")
	public ResponseEntity<List<Client>> getByClientName(@PathVariable long nameClient){
		 return ResponseEntity.ok(repository.findAllByNameClientContainingIgnoreCase(
				  nameClient));
	}
	
	@PostMapping
	public ResponseEntity<Client> post(@RequestBody Client client){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(client));
	}
}
