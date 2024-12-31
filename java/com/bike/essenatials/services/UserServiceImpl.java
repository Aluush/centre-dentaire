package com.bike.essenatials.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.essenatials.dto.UserDto;
import com.bike.essenatials.entities.UserEntity;
import com.bike.essenatials.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptPassword("test password");
		userEntity.setUserId("user id test");
	
		UserEntity newUser = userRepository.save(userEntity);
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(newUser, userDto);
		
		return userDto;
	}
	
	
	
}