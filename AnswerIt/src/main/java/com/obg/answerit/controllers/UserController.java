package com.obg.answerit.controllers;

import com.obg.answerit.entities.UserEntity;
import com.obg.answerit.repositories.UserRepository;
import com.obg.answerit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("")
    public UserEntity createUser(@RequestBody UserEntity newUser) {
        return userService.createUser(newUser);
    }

    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public UserEntity updateUser(@PathVariable Long userId, @RequestBody UserEntity updatedUserBody) {
        return userService.updateUser(userId, updatedUserBody);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }
}
