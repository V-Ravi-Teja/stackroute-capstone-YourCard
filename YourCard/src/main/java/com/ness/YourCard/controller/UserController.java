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

//  to add:verify if user present already
    @PostMapping(value = "/CreateUser")
    public String addUser(@RequestBody UserDTO userDTO){
        Integer userId = userService.addUser(userDTO);
        return "User with id: " + userId + " added successfully.";
    }

//  to add: check authorization and need to only show username and limit
    @GetMapping(value = "/GetUser/{userId}")
    public UserDTO getUser(@PathVariable Integer userId) {
        UserDTO userdto = userService.getUser(userId);
        return userdto;
    }

//  to add: verify whether user present and authorized
    @PutMapping(value= "UpdateUser/{UserId}")
    public String updateCustomer(@PathVariable Integer userId, @RequestBody UserDTO userDTO) {
        userService.updateUserDetails(userId,userDTO);
        return "user with id: " + userId + " details updated.";
    }

    @DeleteMapping(value = "DeleteUser/{Userid}")
    public String deleteCustomer(@PathVariable Integer Userid){
        userService.deleteUser(Userid);
        return "User with id: " + Userid + " deleted successfully";
    }
}
