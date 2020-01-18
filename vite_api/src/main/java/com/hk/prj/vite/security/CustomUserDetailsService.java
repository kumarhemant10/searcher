package com.hk.prj.vite.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hk.prj.vite.model.CustomUserDetails;
import com.hk.prj.vite.model.User;
import com.hk.prj.vite.repository.UserRepository;
import com.hk.prj.vite.repository.UserRolesRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired UserRepository userRepository;
	
	@Autowired UserRolesRepository userRolesRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user=userRepository.findByUserName(username);
		  if(null == user){
		   throw new UsernameNotFoundException("No user present with username: "+username);
		  }else{
		   List<String> userRoles=userRolesRepository.findRoleByUserName(username);
		   return new CustomUserDetails(user,userRoles);
		  }
	}

}
