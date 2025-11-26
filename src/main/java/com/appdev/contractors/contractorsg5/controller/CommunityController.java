package com.appdev.contractors.contractorsg5.controller;

import org.springframework.web.bind.annotation.RestController;
import com.appdev.contractors.contractorsg5.entity.CommunityEntity;
import com.appdev.contractors.contractorsg5.service.CommunityService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;


@RestController
@RequestMapping("/community")
public class CommunityController {
  
    private final CommunityService service;

    public CommunityController(CommunityService service){
        this.service = service;
    }
    @PostMapping
    public CommunityEntity addCommunity(@RequestBody CommunityEntity comm){
        return service.saveCommunity(comm);
    }

    @GetMapping
    public List<CommunityEntity> getCommunity(){
        return service.getAllCommunity();
    }
}
