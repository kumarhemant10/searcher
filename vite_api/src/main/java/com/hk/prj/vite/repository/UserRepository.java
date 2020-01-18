package com.hk.prj.vite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hk.prj.vite.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 public User findByUserName(String username);
}
