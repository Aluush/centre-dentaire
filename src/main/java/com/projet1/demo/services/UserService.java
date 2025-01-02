package com.projet1.demo.services;

import com.projet1.demo.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.projet1.demo.dto.UserDto;

public interface UserService extends UserDetailsService{

	public UserDto createUser(UserDto userDto);
	public 	UserDto getUser(String email);

	public Iterable<UserEntity> getAllUsers();
}
