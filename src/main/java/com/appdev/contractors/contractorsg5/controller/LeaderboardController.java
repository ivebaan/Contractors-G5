package com.appdev.contractors.contractorsg5.controller;


import org.springframework.web.bind.annotation.*;
import com.appdev.contractors.contractorsg5.entity.LeaderboardEntity;
import com.appdev.contractors.contractorsg5.service.LeaderboardService;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
public class LeaderboardController {

    private final LeaderboardService service;

    public LeaderboardController(LeaderboardService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public LeaderboardEntity addLeaderboard(@RequestBody LeaderboardEntity lead) {
        return service.saveLeaderboard(lead);
    }

    @GetMapping("/getAll")
    public List<LeaderboardEntity> getLeaderboard() {
        return service.getAllLeaderboard();
    }

    @GetMapping("/get/{id}")
    public LeaderboardEntity getLeaderboardById(@PathVariable Long id) {
        return service.getLeaderboardById(id);
    }

    @PutMapping("/update/{id}")
    public LeaderboardEntity updateLeaderboard(@PathVariable Long id, @RequestBody LeaderboardEntity lead) {
        return service.updateLeaderboard(id, lead);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLeaderboard(@PathVariable Long id) {
        boolean deleted = service.deleteLeaderboard(id);
        return deleted ? "Deleted" : "Not Found";
    }
}