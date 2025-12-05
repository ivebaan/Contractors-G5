package com.appdev.contractors.contractorsg5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leaderboard")
public class LeaderboardEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaderboardId;

    private int userId;
    private int points;
    private int userRank;
    private String lastUpdated;

    public LeaderboardEntity(){}

    public LeaderboardEntity(int userId, int points, int userRank, String lastUpdated){
      this.userId = userId;
      this.points = points;
      this.userRank = userRank;
      this.lastUpdated = lastUpdated;
    }

    public void setLeaderboardId(Long leaderboardId){
        this.leaderboardId = leaderboardId;
    }
    public Long getLeaderboardId(){
        return leaderboardId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }
    public int getUserId(){
        return userId;
    }

    public void setPoints(int points){
        this.points = points;
    }
    public int getPoints(){
        return points;
    }
    
    public void setRank(int userRank){
        this.userRank = userRank;
    }
    public int getRank(){
        return userRank;
    }

    public void setLastUpdated(String lastUpdated){
        this.lastUpdated = lastUpdated;
    }
    public String getLastUpdated(){
        return lastUpdated;
    }

}
