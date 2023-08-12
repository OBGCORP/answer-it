package com.obg.answerit.controllers;

import com.obg.answerit.entities.UserEntity;
import com.obg.answerit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("")
    public UserEntity createUser(@RequestBody UserEntity newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/{userId}")
    public UserEntity getUser(@PathVariable Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @PutMapping("/{userId}")
    public UserEntity updateUser(@PathVariable Long userId, @RequestBody UserEntity updatedUserBody) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if(user.isPresent()) {
            UserEntity userToBeUpdated = user.get();
            userToBeUpdated.setUsername(updatedUserBody.getUsername());
            userToBeUpdated.setPassword(updatedUserBody.getPassword());
            userRepository.save(userToBeUpdated);
            return updatedUserBody;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
}
