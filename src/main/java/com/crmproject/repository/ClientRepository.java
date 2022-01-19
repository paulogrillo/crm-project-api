package com.crmproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crmproject.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	 List<Client> findAllByNameClientContainingIgnoreCase(String nameClient);
	 List<Client> findAllById(long id);


	
}
