package com.bike.essenatials.controllers;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bike.essenatials.dto.UserDto;
import com.bike.essenatials.request.UserRequest;
import com.bike.essenatials.response.UserResponse;
import com.bike.essenatials.services.UserService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;

//    @GetMapping("/users")
  //  public String getAllUsers() {
    //    return "Liste de tous les utilisateurs";
    //}

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable("id") int id) {
        return "Utilisateur avec l'ID " + id;
    }

    @PostMapping("/users")
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto); 
        UserDto createUser = userService.createUser(userDto);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(createUser, userResponse);
        return userResponse;
    }


    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody String updatedUser) {
        return "Utilisateur avec l'ID " + id + " mis à jour";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        return "Utilisateur avec l'ID " + id + " supprimé avec succès";
    }
}
