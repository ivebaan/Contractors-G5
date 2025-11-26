package com.appdev.contractors.aytonag5.controller;

import com.appdev.contractors.aytonag5.entity.PostEntity;
import com.appdev.contractors.aytonag5.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public PostEntity createPost(@RequestBody PostEntity post) {
        return postService.savePost(post);
    }

    @GetMapping
    public List<PostEntity> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostEntity getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return "Post with ID " + id + " has been deleted.";
    }
}
