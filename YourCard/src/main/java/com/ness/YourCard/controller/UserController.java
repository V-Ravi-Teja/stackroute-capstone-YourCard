package com.ness.YourCard.controller;

import com.ness.YourCard.DTO.UserDTO;
import com.ness.YourCard.service.UserService;
import com.ness.YourCard.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/yourcard")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/CreateUser")
    public String addUser(@RequestBody UserDTO userDTO){
        Integer userId = userService.addUser(userDTO);
        return "User with id: " + userId + " added successfully.";
    }

    @GetMapping(value = "/GetUser/{userId}")
    public UserDTO getUser(@PathVariable Integer userId) {
        UserDTO userdto = userService.getUser(userId);
        return userdto;
    }
}
