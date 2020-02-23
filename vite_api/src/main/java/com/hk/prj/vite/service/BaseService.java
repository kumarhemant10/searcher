package com.hk.prj.vite.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;

import com.hk.prj.vite.model.CustomUserDetails;

public interface BaseService {
	
	default CustomUserDetails getLoggedInUser() {
		Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();		
		return (ObjectUtils.isEmpty(authentication) || authentication.getPrincipal() instanceof String) ?null:(CustomUserDetails)authentication.getPrincipal();
	}
}
