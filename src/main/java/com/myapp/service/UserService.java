package com.myapp.service;

import com.myapp.dto.UserDTO;
import com.myapp.model.User;

import java.util.List;

public interface UserService {
    UserDTO addUser(UserDTO user);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
}
