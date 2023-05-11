package com.ness.YourCard.service;

import com.ness.YourCard.DTO.UserDTO;
import com.ness.YourCard.entity.User;
import com.ness.YourCard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Integer addUser(UserDTO userDTO){
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUserName(userDTO.getUserName());
        user.setUserPassword(userDTO.getUserPassword());
        user.setUserLimit(userDTO.getUserLimit());
        userRepository.save(user);
        return user.getUserId();
    }

    @Override
    public UserDTO getUser(Integer userId) {
        Optional<User> optional = userRepository.findById(userId);
        User user = optional.get();
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setUserPassword(user.getUserPassword());
        userDTO.setUserLimit(user.getUserLimit());
        return userDTO;
    }
}
