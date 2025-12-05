package com.appdev.contractors.contractorsg5.service;

import com.appdev.contractors.contractorsg5.entity.PostEntity;
import com.appdev.contractors.contractorsg5.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // --- CREATE ---
    public PostEntity savePost(PostEntity post) {
        return postRepository.save(post);
    }

    // --- READ ALL ---
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    // --- READ BY ID ---
    public PostEntity getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post with id " + id + " not found"));
    }

    // --- UPDATE ---
    public PostEntity updatePost(Long id, PostEntity updatedPost) {
        PostEntity existingPost = getPostById(id);

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setCreatedBy(updatedPost.getCreatedBy());
        existingPost.setCommunity(updatedPost.getCommunity());
        existingPost.setVotes(updatedPost.getVotes());
        existingPost.setIsFavorite(updatedPost.getIsFavorite());

        return postRepository.save(existingPost);
    }

    // --- DELETE ---
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new IllegalArgumentException("Post with id " + id + " not found");
        }
        postRepository.deleteById(id);
    }
}
