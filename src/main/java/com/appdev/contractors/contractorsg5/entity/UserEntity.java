package com.appdev.contractors.contractorsg5.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String displayName;
    private String email;

    @com.fasterxml.jackson.annotation.JsonProperty("password")
    private String password;
    public UserEntity() {}

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CommentsEntity> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserCommunityEntity> userCommunities;

    // --- Getters & Setters ---
    public Long getUserId() { return userId; }
        public Long getId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<CommentsEntity> getComments() { return comments; }
    public void setComments(List<CommentsEntity> comments) { this.comments = comments; }

    public List<UserCommunityEntity> getUserCommunities() { return userCommunities; }
    public void setUserCommunities(List<UserCommunityEntity> userCommunities) { this.userCommunities = userCommunities; }
}
