package com.appdev.contractors.contractorsg5.service;

import org.springframework.stereotype.Service;

import java.util.List;
import com.appdev.contractors.contractorsg5.entity.LeaderboardEntity;
import com.appdev.contractors.contractorsg5.repository.LeaderboardRepository;

@Service
public class LeaderboardService {

    private final LeaderboardRepository repo;

    public LeaderboardService(LeaderboardRepository repo){
        this.repo = repo;
    }

    public LeaderboardEntity saveLeaderboard(LeaderboardEntity lead){
        return repo.save(lead);
    }
   public List<LeaderboardEntity> getAllLeaderboard(){
    return repo.findAll();
   }
}
