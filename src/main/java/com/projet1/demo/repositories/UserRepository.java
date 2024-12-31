package com.projet1.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.projet1.demo.entities.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{

	UserEntity  findByEmail(String email);
	
}
