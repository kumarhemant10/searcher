package com.hk.prj.vite.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hk.prj.vite.exception.ResourceNotFoundException;
import com.hk.prj.vite.model.User;
import com.hk.prj.vite.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, BaseService  {

	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	
	@Override
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public List<User> save(List<User> users) {
		users.stream().map(user-> {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return user;
		}).collect(Collectors.toList());
		
		return userRepository.save(users);
	}

	@Override
	public List<User> get() {
		return userRepository.findAll();
	}

	@Override
	public User get(long userId) {
		return userRepository.findByUserId(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with ID: "+userId));
	}

	@Override
	public void delete(long userId) {
		//check if user is there with passed Id else throw an error
		User user = userRepository.findByUserId(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with ID: "+userId));
		//delete that user
		userRepository.delete(user);
	}

	
}
