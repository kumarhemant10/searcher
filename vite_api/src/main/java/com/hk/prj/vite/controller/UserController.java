package com.hk.prj.vite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.prj.vite.dto.UserDTO;
import com.hk.prj.vite.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDTO> save(@RequestBody UserDTO user){
		return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
	}
}
