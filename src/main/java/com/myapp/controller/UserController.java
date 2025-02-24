package com.myapp.controller;

import com.myapp.dto.UserDTO;
import com.myapp.model.User;
import com.myapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDTO user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser((user)));
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }
}
