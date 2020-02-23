package com.hk.prj.vite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hk.prj.vite.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUserName(String username);

	public Optional<User> findByUserId(long userId);
}
