package com.ness.YourCard.service;

import com.ness.YourCard.DTO.UserDTO;

public interface UserService {

    public Integer addUser(UserDTO userDTO);

    UserDTO getUser(Integer userId);
}
