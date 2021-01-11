package com.docdb.service;

import org.springframework.stereotype.Service;

import com.docdb.model.entity.User;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class UserService extends BasePersistenceService<User, Integer> {
			
	public UserService(BaseRepository<User, Integer> baseRepository) {
		super(baseRepository);
	}

}
