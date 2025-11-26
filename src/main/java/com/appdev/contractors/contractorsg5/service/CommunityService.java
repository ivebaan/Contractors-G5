package com.appdev.contractors.contractorsg5.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.appdev.contractors.contractorsg5.entity.CommunityEntity;
import com.appdev.contractors.contractorsg5.repository.CommunityRepository;



@Service
public class CommunityService{
 
    private final CommunityRepository repo;

    public CommunityService(CommunityRepository repo){
        this.repo = repo;
    }

    public CommunityEntity saveCommunity(CommunityEntity comm){
        return repo.save(comm);
    }
    public List<CommunityEntity> getAllCommunity(){
        return repo.findAll();
    }


}