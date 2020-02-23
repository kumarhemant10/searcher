package com.hk.prj.vite.service;

import java.util.List;

import com.hk.prj.vite.model.User;

public interface UserService {

	User save(User user);
	
	List<User> save(List<User> users);
	
	List<User> get();

	User get(long userId);

	void delete(long userId);

}
