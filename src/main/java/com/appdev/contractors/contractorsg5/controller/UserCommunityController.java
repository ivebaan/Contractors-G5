package com.appdev.contractors.contractorsg5.controller;

import com.appdev.contractors.contractorsg5.entity.UserCommunityEntity;
import com.appdev.contractors.contractorsg5.service.UserCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/usercommunity")
public class UserCommunityController {

    @Autowired
    private UserCommunityService userCommunityService;

    // Endpoint to add a user to a community
    @PostMapping("/create")
    public ResponseEntity<String> addUserToCommunity(
            @RequestParam Long userId,
            @RequestParam Long communityId,
            @RequestParam(required = false) LocalDateTime joinDate) {

        try {
            userCommunityService.addUserToCommunity(userId, communityId, joinDate);
            return ResponseEntity.ok("User added to the community successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error: " + e.getMessage());
        }
    }

    // Endpoint to remove a user from a community
    @DeleteMapping("/removeuser")
    public ResponseEntity<String> removeUserFromCommunity(
            @RequestParam Long userId,
            @RequestParam Long communityId) {

        try {
            userCommunityService.removeUserFromCommunity(userId, communityId);
            return ResponseEntity.ok("User removed from the community successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error: " + e.getMessage());
        }
    }

    // Endpoint to get all communities a user has joined
    @GetMapping("/user/{userId}/communities")
    public ResponseEntity<List<UserCommunityEntity>> getAllCommunitiesForUser(@PathVariable Long userId) {
        try {
            List<UserCommunityEntity> communities = userCommunityService.getAllCommunitiesForUser(userId);
            return ResponseEntity.ok(communities);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    // Endpoint to get all users in a specific community
    @GetMapping("/community/{communityId}/users")
    public ResponseEntity<List<UserCommunityEntity>> getAllUsersInCommunity(@PathVariable Long communityId) {
        try {
            List<UserCommunityEntity> users = userCommunityService.getAllUsersInCommunity(communityId);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }
}
