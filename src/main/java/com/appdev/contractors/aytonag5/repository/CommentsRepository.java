package com.appdev.contractors.aytonag5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appdev.contractors.aytonag5.entity.CommentsEntity;

public interface CommentsRepository extends JpaRepository<CommentsEntity, Long> {
}
