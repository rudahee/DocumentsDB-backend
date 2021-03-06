package com.docdb.model.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.docdb.model.entity.User;
import com.docdb.model.repository.base.BaseRepository;
@Repository
public interface UserRepository extends BaseRepository<User, Integer>{

	User findByUsername(String username);
	
	Boolean existsByUsernameIgnoreCase(String username);
	
	Boolean existsByEmailIgnoreCase(String email);

	Optional<User> findByUsernameAndPassword(String username, String password);
	
	
}
