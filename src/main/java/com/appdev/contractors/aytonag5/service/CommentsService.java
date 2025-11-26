package com.appdev.contractors.aytonag5.service;

import com.appdev.contractors.aytonag5.entity.CommentsEntity;
import com.appdev.contractors.aytonag5.repository.CommentsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    // CREATE
    public CommentsEntity createComment(CommentsEntity comment) {
        return commentsRepository.save(comment);
    }

    // READ
    public List<CommentsEntity> getAllComments() {
        return commentsRepository.findAll();
    }

    // UPDATE
    public CommentsEntity updateComment(Long id, CommentsEntity newCommentData) {
        return commentsRepository.findById(id).map(comment -> {
            comment.setContent(newCommentData.getContent());
            comment.setPostId(newCommentData.getPostId());
            comment.setDateCommented(newCommentData.getDateCommented());
            return commentsRepository.save(comment);
        }).orElse(null);
    }

    // DELETE
    public void deleteComment(Long id) {
        commentsRepository.deleteById(id);
    }
}

