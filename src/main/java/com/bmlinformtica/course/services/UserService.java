package com.bmlinformtica.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmlinformtica.course.entities.User;
import com.bmlinformtica.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository Userrepo;
	
	public List<User> findAll() {
		return Userrepo.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = Userrepo.findById(id);
		return obj.get();
	}
}
