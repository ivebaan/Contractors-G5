package com.appdev.contractors.contractorsg5.controller;

import com.appdev.contractors.contractorsg5.entity.UserEntity;
import com.appdev.contractors.contractorsg5.entity.UserCommunityEntity;
import com.appdev.contractors.contractorsg5.service.UserCommunityService;
import com.appdev.contractors.contractorsg5.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserCommunityService userCommunityService;

    // Constructor injection for both services
    public UserController(UserService userService, UserCommunityService userCommunityService) {
        this.userService = userService;
        this.userCommunityService = userCommunityService;
    }

    // CREATE
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }
    
    // READ
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
    

    // UPDATE
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        return userService.updateUser(id, user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User with ID " + id + " deleted successfully.";
    }

    // --- NEW ENDPOINTS FOR USER-COMMUNITY RELATIONSHIP ---

    // Add a user to a community
    @PostMapping("/{userId}/joinCommunity")
    public String addUserToCommunity(
            @PathVariable Long userId,
            @RequestParam Long communityId,
            @RequestParam(required = false) LocalDateTime joinDate) {

        try {
            userCommunityService.addUserToCommunity(userId, communityId, joinDate);
            return "User successfully added to the community.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // Remove a user from a community
    @DeleteMapping("/{userId}/leaveCommunity")
    public String removeUserFromCommunity(
            @PathVariable Long userId,
            @RequestParam Long communityId) {

        try {
            userCommunityService.removeUserFromCommunity(userId, communityId);
            return "User successfully removed from the community.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // Get all communities a user has joined
    @GetMapping("/{userId}/communities")
    public List<UserCommunityEntity> getAllCommunitiesForUser(@PathVariable Long userId) {
        try {
            return userCommunityService.getAllCommunitiesForUser(userId);
        } catch (Exception e) {
            return null;  // You can handle the error response as needed
        }
    }
}
