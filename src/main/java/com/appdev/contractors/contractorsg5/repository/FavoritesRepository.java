package com.appdev.contractors.contractorsg5.repository;

import com.appdev.contractors.contractorsg5.entity.FavoritesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<FavoritesEntity, Long> {
    
}
