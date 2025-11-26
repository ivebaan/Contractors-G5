package com.appdev.contractors.contractorsg5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appdev.contractors.contractorsg5.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
