package com.appdev.contractors.contractorsg5.repository;

import com.appdev.contractors.contractorsg5.entity.UserCommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCommunityRepository extends JpaRepository<UserCommunityEntity, Long> {
    
}