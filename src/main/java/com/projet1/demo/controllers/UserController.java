package com.projet1.demo.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.projet1.demo.dto.UserDto;
import com.projet1.demo.requests.UserRequest;
import com.projet1.demo.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/list";
    }

    @GetMapping("/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "users/create";
    }

    @PostMapping
    public String createUser(@ModelAttribute("userRequest") UserRequest userRequest, Model model) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);
        UserDto createdUser = userService.createUser(userDto);
        model.addAttribute("user", createdUser);
        return "redirect:/users"; // Redirige vers la liste des utilisateurs
    }


}
