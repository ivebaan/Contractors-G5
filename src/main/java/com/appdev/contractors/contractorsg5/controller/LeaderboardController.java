package com.appdev.contractors.contractorsg5.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.appdev.contractors.contractorsg5.entity.LeaderboardEntity;
import com.appdev.contractors.contractorsg5.service.LeaderboardService;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
public class LeaderboardController {

    private final LeaderboardService service;

    public LeaderboardController(LeaderboardService service){
        this.service = service;
    }
    @PostMapping
    public LeaderboardEntity addLeaderboard(@RequestBody LeaderboardEntity lead){
        return service.saveLeaderboard(lead);
    }

    @GetMapping
    public List<LeaderboardEntity> getLeaderboard(){
        return service.getAllLeaderboard();
    }
}
