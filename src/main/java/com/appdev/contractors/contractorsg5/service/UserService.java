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

    // READ
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // UPDATE
    public UserEntity updateUser(Long id, UserEntity newUserData) {
        return userRepository.findById(id).map(user -> {
            user.setFullName(newUserData.getFullName());
            user.setInstitutionalEmail(newUserData.getInstitutionalEmail());
            user.setPassword(newUserData.getPassword());
            user.setRole(newUserData.getRole());
            return userRepository.save(user);
        }).orElse(null);
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
