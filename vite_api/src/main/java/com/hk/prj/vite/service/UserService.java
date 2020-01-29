package com.hk.prj.vite.service;

import com.hk.prj.vite.dto.UserDTO;
import com.hk.prj.vite.model.CustomUserDetails;

public interface UserService {

	UserDTO save(UserDTO user);
	
	CustomUserDetails getLoggedInUser();

}
