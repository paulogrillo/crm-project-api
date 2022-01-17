package com.crmproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crmproject.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	 List<User> findAllByUsernameContainingIgnoreCase(String username);
	 Optional<List <User>> findAllByUsername(String username);
}
