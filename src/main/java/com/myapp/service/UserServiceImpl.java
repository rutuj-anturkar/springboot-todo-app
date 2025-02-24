package com.myapp.service;

import com.myapp.custom_exceptions.ResourceNotFoundException;
import com.myapp.dto.UserDTO;
import com.myapp.model.User;
import com.myapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserDTO addUser(UserDTO dto) {
        // DTO to model
        User userModel = modelMapper.map(dto, User.class);
        return modelMapper.map(userRepository.save(userModel),UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map((user)-> modelMapper.map(user,UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return modelMapper.map(userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("getUserById ScenarioUser ID doesn't exist")
                ),UserDTO.class);
    }
}
