package com.projet1.demo.controllers;

import com.projet1.demo.entities.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projet1.demo.dto.UserDto;
import com.projet1.demo.requests.UserRequest;
import com.projet1.demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    // Récupérer tous les utilisateurs
    @GetMapping
    public Iterable<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    // Récupérer un utilisateur par son ID
 //   @GetMapping("/{id}")
  //  public UserDto getUserById(@PathVariable Long id) {
    //    return userService.getUserById(id);
   // }

    // Créer un nouvel utilisateur
    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserRequest userRequest) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);
        return userService.createUser(userDto);
    }

    // Mettre à jour un utilisateur existant
//    @PutMapping("/{id}")
//    public UserDto updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
//        UserDto userDto = new UserDto();
//        BeanUtils.copyProperties(userRequest, userDto);
//        return userService.updateUser(id, userDto);
//    }
//
//    // Supprimer un utilisateur
//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return "Utilisateur supprimé avec succès";
//    }
}
