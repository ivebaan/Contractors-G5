package com.appdev.contractors.contractorsg5.service;

import com.appdev.contractors.contractorsg5.entity.UserEntity;
import com.appdev.contractors.contractorsg5.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    // READ by ID
public UserEntity getById(Long id) {
    return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
}

    // READ
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // UPDATE
    public UserEntity updateUser(Long id, UserEntity newUserData) {
        return userRepository.findById(id).map(user -> {
            user.setDisplayName(newUserData.getDisplayName());
            user.setEmail(newUserData.getEmail());
            user.setPassword(newUserData.getPassword());
            return userRepository.save(user);
        }).orElse(null);
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
