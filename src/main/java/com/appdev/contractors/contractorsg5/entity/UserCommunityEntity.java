package com.appdev.contractors.contractorsg5.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "userCommunity")
public class UserCommunityEntity {

    public UserCommunityEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCommunityid;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "community_id", nullable = false)
    private CommunityEntity community;

    private LocalDateTime joinDate;

    public UserCommunityEntity(UserEntity user, CommunityEntity community, LocalDateTime joinDate) {
    this.user = user;
    this.community = community;
    this.joinDate = joinDate;
}

    // Getters and setters
    public Long getCommunityId() {
        return userCommunityid;
    }

    public void setCommunityId(Long userCommunityid) {
        this.userCommunityid = userCommunityid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CommunityEntity getCommunity() {
        return community;
    }

    public void setCommunity(CommunityEntity community) {
        this.community = community;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

}
