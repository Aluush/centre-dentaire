package com.bike.essenatials.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bike.essenatials.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{

	
	
}
