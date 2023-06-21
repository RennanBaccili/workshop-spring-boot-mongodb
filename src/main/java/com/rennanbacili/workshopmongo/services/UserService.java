package com.rennanbacili.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rennanbacili.workshopmongo.domain.User;
import com.rennanbacili.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findeAll(){
		return repo.findAll();
	}
}
