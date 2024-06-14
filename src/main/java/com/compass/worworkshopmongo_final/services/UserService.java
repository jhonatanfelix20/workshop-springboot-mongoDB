package com.compass.worworkshopmongo_final.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.workshopmongo_final.domain.User;
import com.compass.worworkshopmongo_final.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
		
	}

}
