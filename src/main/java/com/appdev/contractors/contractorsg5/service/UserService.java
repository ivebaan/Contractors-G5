package com.appdev.contractors.contractorsg5.service;

import com.appdev.contractors.contractorsg5.entity.UserEntity;
import com.appdev.contractors.contractorsg5.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.appdev.contractors.contractorsg5.entity.UserCommunityEntity;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserCommunityService userCommunityService; 
 
    public UserService(UserRepository userRepository, UserCommunityService userCommunityService) {
        this.userRepository = userRepository;
        this.userCommunityService = userCommunityService;
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

    // READ all users
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

    // Add a user to a community (delegating to UserCommunityService)
    public void addUserToCommunity(Long userId, Long communityId) {
        userCommunityService.addUserToCommunity(userId, communityId, null);  // You can add joinDate if needed
    }

    // Remove a user from a community
    public void removeUserFromCommunity(Long userId, Long communityId) {
        userCommunityService.removeUserFromCommunity(userId, communityId);
    }

    // Get all communities a user has joined
    public List<UserCommunityEntity> getAllCommunitiesForUser(Long userId) {
        return userCommunityService.getAllCommunitiesForUser(userId);
    }
}
