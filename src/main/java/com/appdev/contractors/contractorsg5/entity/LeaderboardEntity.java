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
    private int rank;
    private String lastUpdated;

    public LeaderboardEntity(){}

    public LeaderboardEntity(int userId, int points, int rank, String lastUpdated){
      this.userId = userId;
      this.points = points;
      this.rank = rank;
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
    
    public void setRank(int rank){
        this.rank = rank;
    }
    public int getRank(){
        return rank;
    }

    public void setLastUpdated(String lastUpdated){
        this.lastUpdated = lastUpdated;
    }
    public String getLastUpdated(){
        return lastUpdated;
    }

}
