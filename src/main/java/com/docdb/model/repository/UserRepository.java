package com.docdb.model.repository;

import org.springframework.stereotype.Repository;

import com.docdb.model.entity.User;
import com.docdb.model.repository.base.BaseRepository;
@Repository
public interface UserRepository extends BaseRepository<User, Integer>{

	User findByUsernameAndPassword(String username, String password);
	
	User findByToken(String token);
}
