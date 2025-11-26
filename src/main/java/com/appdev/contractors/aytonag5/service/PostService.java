package com.appdev.contractors.aytonag5.service;

import com.appdev.contractors.aytonag5.entity.PostEntity;
import com.appdev.contractors.aytonag5.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostEntity savePost(PostEntity post) {
        return postRepository.save(post);
    }

    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    public PostEntity getPostById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    public void deletePost(int id) {
        postRepository.deleteById(id);
    }
}
