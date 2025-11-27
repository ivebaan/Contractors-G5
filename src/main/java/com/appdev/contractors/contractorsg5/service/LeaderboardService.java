package com.appdev.contractors.contractorsg5.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.appdev.contractors.contractorsg5.entity.LeaderboardEntity;
import com.appdev.contractors.contractorsg5.repository.LeaderboardRepository;

@Service
public class LeaderboardService {

    private final LeaderboardRepository repo;

    public LeaderboardService(LeaderboardRepository repo) {
        this.repo = repo;
    }
    // Create
    public LeaderboardEntity saveLeaderboard(LeaderboardEntity lead) {
        return repo.save(lead);
    }
    // Read
    public List<LeaderboardEntity> getAllLeaderboard() {
        return repo.findAll();
    }

    public LeaderboardEntity getLeaderboardById(Long id) {
        Optional<LeaderboardEntity> opt = repo.findById(id);
        return opt.orElseThrow(() -> new IllegalArgumentException("Leaderboard with id " + id + " not found"));
    }
    // Update
    public LeaderboardEntity updateLeaderboard(Long id, LeaderboardEntity updated) {
        LeaderboardEntity existing = getLeaderboardById(id);
        existing.setUserId(updated.getUserId());
        existing.setPoints(updated.getPoints());
        existing.setRank(updated.getRank());
        existing.setLastUpdated(updated.getLastUpdated());
        return repo.save(existing);
    }
    // Delete
    public boolean deleteLeaderboard(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}