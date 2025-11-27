package com.appdev.contractors.contractorsg5.controller;

import org.springframework.web.bind.annotation.*;
import com.appdev.contractors.contractorsg5.entity.CommunityEntity;
import com.appdev.contractors.contractorsg5.service.CommunityService;


import java.util.List;

@RestController
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService service;

    public CommunityController(CommunityService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public CommunityEntity addCommunity(@RequestBody CommunityEntity comm) {
        return service.saveCommunity(comm);
    }

    @GetMapping("/getAll")
    public List<CommunityEntity> getCommunity() {
        return service.getAllCommunity();
    }

    @GetMapping("/get/{id}")
    public CommunityEntity getCommunityById(@PathVariable Long id) {
        return service.getCommunityById(id);
    }

    @PutMapping("/update/{id}")
    public CommunityEntity updateCommunity(@PathVariable Long id, @RequestBody CommunityEntity comm) {
        return service.updateCommunity(id, comm);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCommunity(@PathVariable Long id) {
        boolean deleted = service.deleteCommunity(id);
        return deleted ? "Deleted" : "Not Found";
    }
}