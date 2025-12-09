package com.appdev.contractors.contractorsg5.service;

import com.appdev.contractors.contractorsg5.entity.UserEntity;
import com.appdev.contractors.contractorsg5.entity.UserCommunityEntity;
import com.appdev.contractors.contractorsg5.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;

@Service
public class UserService {
    // For testing: save user without password encoding
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    private final UserRepository userRepository;
    private final UserCommunityService userCommunityService;
    private final BCryptPasswordEncoder passwordEncoder;

    
    public UserService(UserRepository userRepository, UserCommunityService userCommunityService) {
        this.userRepository = userRepository;
        this.userCommunityService = userCommunityService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // CREATE
    public UserEntity createUser(UserEntity user) {
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // READ by ID
    public UserEntity getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // READ all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // UPDATE
    public UserEntity updateUser(Long id, UserEntity newUserData) {
        return userRepository.findById(id).map(user -> {
            user.setDisplayName(newUserData.getDisplayName());
            user.setEmail(newUserData.getEmail());
            // Only update password if not empty
            if (newUserData.getPassword() != null && !newUserData.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(newUserData.getPassword()));
            }
            return userRepository.save(user);
        }).orElse(null);
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // LOGIN
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean checkPassword(UserEntity user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    // COMMUNITY METHODS
    public void addUserToCommunity(Long userId, Long communityId) {
        userCommunityService.addUserToCommunity(userId, communityId, null);
    }

    public void removeUserFromCommunity(Long userId, Long communityId) {
        userCommunityService.removeUserFromCommunity(userId, communityId);
    }

    public List<UserCommunityEntity> getAllCommunitiesForUser(Long userId) {
        return userCommunityService.getAllCommunitiesForUser(userId);
    }
}
