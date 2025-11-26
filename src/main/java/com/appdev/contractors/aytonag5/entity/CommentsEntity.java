package com.appdev.contractors.aytonag5.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private Long postId;
    private String content;
    private LocalDateTime dateCommented = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    // Getters and Setters
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateCommented() {
        return dateCommented;
    }

    public void setDateCommented(LocalDateTime dateCommented) {
        this.dateCommented = dateCommented;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

