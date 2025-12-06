package com.appdev.contractors.contractorsg5.service;

import com.appdev.contractors.contractorsg5.entity.UserCommunityEntity;
import com.appdev.contractors.contractorsg5.entity.UserEntity;
import com.appdev.contractors.contractorsg5.entity.CommunityEntity;
import com.appdev.contractors.contractorsg5.repository.UserCommunityRepository;
import com.appdev.contractors.contractorsg5.repository.UserRepository;
import com.appdev.contractors.contractorsg5.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserCommunityService {

    @Autowired
    private UserCommunityRepository userCommunityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommunityRepository communityRepository;

    // Add a user to a community
    @Transactional
    public UserCommunityEntity addUserToCommunity(Long userId, Long communityId, LocalDateTime joinDate) {
        // Find the user by ID
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Find the community by ID
        CommunityEntity community = communityRepository.findById(communityId)
                .orElseThrow(() -> new RuntimeException("Community not found"));

        // Create the UserCommunityEntity to represent the relationship
        UserCommunityEntity userCommunity = new UserCommunityEntity();
        userCommunity.setUser(user);
        userCommunity.setCommunity(community);
        userCommunity.setJoinDate(joinDate != null ? joinDate : LocalDateTime.now());  // Set join date if provided, else set the current time

        // Save the entity to the repository
        return userCommunityRepository.save(userCommunity);
    }

    // Remove a user from a community
    @Transactional
    public void removeUserFromCommunity(Long userId, Long communityId) {
        // Find the relationship in the repository
        Optional<UserCommunityEntity> userCommunityOpt = userCommunityRepository.findAll()
                .stream()
                .filter(uc -> uc.getUser().getUserId().equals(userId) && uc.getCommunity().getCommunityId().equals(communityId))
                .findFirst();

        if (userCommunityOpt.isPresent()) {
            // If found, delete the relationship
            userCommunityRepository.delete(userCommunityOpt.get());
        } else {
            throw new RuntimeException("User is not part of the specified community");
        }
    }

    // Get all communities a user has joined
    public List<UserCommunityEntity> getAllCommunitiesForUser(Long userId) {
        return userCommunityRepository.findAll()
                .stream()
                .filter(uc -> uc.getUser().getUserId().equals(userId))
                .toList();
    }

    // Get all users in a community
    public List<UserCommunityEntity> getAllUsersInCommunity(Long communityId) {
        return userCommunityRepository.findAll()
                .stream()
                .filter(uc -> uc.getCommunity().getCommunityId().equals(communityId))
                .toList();
    }
}
