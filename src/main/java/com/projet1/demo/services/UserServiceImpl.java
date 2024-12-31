package com.projet1.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projet1.demo.dto.UserDto;
import com.projet1.demo.entities.UserEntity;
import com.projet1.demo.repositories.UserRepository;
import com.projet1.demo.shared.Utils;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity checkUser =  userRepository.findByEmail(user.getEmail());
		
		if(checkUser!=null) throw new RuntimeException("user already exists");
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(user, userEntity);
		userEntity.setEncryptPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setUserId(utils.generateUserId(32));

		UserEntity newUser = userRepository.save(userEntity);
		
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(newUser, userDto);
		
		return userDto;
	}



	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		return new User(userEntity.getEmail() , userEntity.getEncryptPassword() , new ArrayList<>());
	}



	@Override
	public UserDto getUser(String email) {
	
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userEntity, userDto);
		
		return userDto;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return (List<UserEntity>) userRepository.findAll();
	}


}