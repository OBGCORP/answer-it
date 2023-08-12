package com.obg.answerit.services;

import com.obg.answerit.entities.UserEntity;
import com.obg.answerit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity createUser(UserEntity newUser) {
        return userRepository.save(newUser);
    }

    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public UserEntity updateUser(Long userId, UserEntity updatedUserBody) {
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

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
