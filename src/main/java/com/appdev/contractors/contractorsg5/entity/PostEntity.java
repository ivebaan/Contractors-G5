package com.appdev.contractors.contractorsg5.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    private int userId;
    private String title;
    private String content;
    private LocalDate datePosted;
    private String author;
    private boolean verified;
    private boolean favorite;
    private int votes;
    private String comments;

    public PostEntity() {}

    public PostEntity(int userId, String title, String content, LocalDate datePosted, String author,
                      boolean verified, boolean favorite, int votes, String comments) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.datePosted = datePosted;
        this.author = author;
        this.verified = verified;
        this.favorite = favorite;
        this.votes = votes;
        this.comments = comments;
    }

    // --- Getters and Setters ---
    public int getPostId() { return postId; }
    public void setPostId(int postId) { this.postId = postId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDate getDatePosted() { return datePosted; }
    public void setDatePosted(LocalDate datePosted) { this.datePosted = datePosted; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public boolean isVerified() { return verified; }
    public void setVerified(boolean verified) { this.verified = verified; }

    public boolean isFavorite() { return favorite; }
    public void setFavorite(boolean favorite) { this.favorite = favorite; }

    public int getVotes() { return votes; }
    public void setVotes(int votes) { this.votes = votes; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    // --- Helper Methods ---
    public void createPost(int userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.datePosted = LocalDate.now();
    }

    public void editPost(String newTitle, String newContent) {
        this.title = newTitle;
        this.content = newContent;
    }

    public void deletePost() {
        this.title = null;
        this.content = null;
    }

    public String viewPost() {
        return "Post Info:\n" +
                "Post ID: " + postId + "\n" +
                "User ID: " + userId + "\n" +
                "Title: " + title + "\n" +
                "Content: " + content + "\n" +
                "Date Posted: " + datePosted + "\n";
    }
}
