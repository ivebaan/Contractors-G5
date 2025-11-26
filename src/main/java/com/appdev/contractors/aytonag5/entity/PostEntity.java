package com.appdev.contractors.aytonag5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;

    private int user_id;
    private String title;
    private String content;
    private LocalDate date_posted;

    public PostEntity() {}

    public PostEntity(int user_id, String title, String content, LocalDate date_posted) {
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.date_posted = date_posted;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate_posted() {
        return date_posted;
    }

    public void setDate_posted(LocalDate date_posted) {
        this.date_posted = date_posted;
    }

    public void createPost(int user_id, String title, String content) {
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.date_posted = LocalDate.now();
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
               "Post ID: " + post_id + "\n" +
               "User ID: " + user_id + "\n" +
               "Title: " + title + "\n" +
               "Content: " + content + "\n" +
               "Date Posted: " + date_posted + "\n";
    }
}
