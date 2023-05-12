package com.ness.YourCard.service;

import com.ness.YourCard.DTO.UserDTO;

public interface UserService {

    public Integer addUser(UserDTO userDTO);

    UserDTO getUser(Integer userId);

    boolean checkIfUserPresent(int userId);

    void updateUserDetails(Integer userId, UserDTO userDTO);

    void deleteUser(Integer userid);
}
