package com.hk.prj.vite.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hk.prj.vite.constant.UrlConstants;
import com.hk.prj.vite.dto.UserDTO;
import com.hk.prj.vite.model.User;
import com.hk.prj.vite.service.UserService;

@RestController
public class UserController extends BaseController{

	@Autowired UserService userService;
	
	@GetMapping(UrlConstants.USERS)
	public ResponseEntity<List<UserDTO>> get(){
		List<User> users = userService.get();
		List<UserDTO> dtos =  users.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@PostMapping(UrlConstants.USERS)
	public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO){
		User user = convertDTOToEntity(userDTO);
		user = userService.save(user);
		return new ResponseEntity<>(convertEntityToDTO(user), HttpStatus.CREATED);
	}

	@GetMapping(UrlConstants.USERS_BY_ID)
	public ResponseEntity<UserDTO> get(@PathVariable long userId){
		User user = userService.get(userId);
		return new ResponseEntity<>(convertEntityToDTO(user), HttpStatus.OK);
	}
	
	@DeleteMapping(UrlConstants.USERS_BY_ID)
	public ResponseEntity<?> delete(@PathVariable long userId){
		userService.delete(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	private UserDTO convertEntityToDTO(User user){
		return modelMapper.map(user, UserDTO.class);
	}
	
	private User convertDTOToEntity(UserDTO dto){
		return modelMapper.map(dto, User.class);
	}
}
