package com.appdev.contractors.contractorsg5.controller;

import com.appdev.contractors.contractorsg5.entity.UserEntity;
import com.appdev.contractors.contractorsg5.entity.UserCommunityEntity;
import com.appdev.contractors.contractorsg5.service.UserCommunityService;
import com.appdev.contractors.contractorsg5.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // Allow React frontend
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserCommunityService userCommunityService;

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

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        UserEntity user = userService.findByEmail(request.getEmail());
        if (user != null && userService.checkPassword(user, request.getPassword())) {
            // Return user without password
            user.setPassword(null);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    // COMMUNITY METHODS
    @PostMapping("/{userId}/joinCommunity")
    public String addUserToCommunity(@PathVariable Long userId,
                                     @RequestParam Long communityId,
                                     @RequestParam(required = false) LocalDateTime joinDate) {
        try {
            userCommunityService.addUserToCommunity(userId, communityId, joinDate);
            return "User successfully added to the community.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @DeleteMapping("/{userId}/leaveCommunity")
    public String removeUserFromCommunity(@PathVariable Long userId,
                                          @RequestParam Long communityId) {
        try {
            userCommunityService.removeUserFromCommunity(userId, communityId);
            return "User successfully removed from the community.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/{userId}/communities")
    public List<UserCommunityEntity> getAllCommunitiesForUser(@PathVariable Long userId) {
        try {
            return userCommunityService.getAllCommunitiesForUser(userId);
        } catch (Exception e) {
            return null;
        }
    }
}
