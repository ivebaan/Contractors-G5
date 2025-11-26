package com.appdev.contractors.aytonag5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appdev.contractors.aytonag5.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
