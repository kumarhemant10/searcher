package com.hk.prj.vite.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hk.prj.vite.dto.UserDTO;
import com.hk.prj.vite.model.User;
import com.hk.prj.vite.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired ModelMapper modelMapper;

	
	@Override
	public UserDTO save(UserDTO dto) {
		User user = modelMapper.map(dto, User.class);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setActive(Boolean.TRUE);
		userRepository.save(user);
		return modelMapper.map(user, UserDTO.class);
	}

}
