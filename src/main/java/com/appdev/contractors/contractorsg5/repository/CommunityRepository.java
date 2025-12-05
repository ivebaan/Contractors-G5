package com.appdev.contractors.contractorsg5.repository;

import com.appdev.contractors.contractorsg5.entity.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<CommunityEntity, Long> {
    CommunityEntity findByName(String name);
}
