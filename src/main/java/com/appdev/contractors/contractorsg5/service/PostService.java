package com.appdev.contractors.contractorsg5.service;

import com.appdev.contractors.contractorsg5.entity.PostEntity;
import com.appdev.contractors.contractorsg5.entity.UserEntity;
import com.appdev.contractors.contractorsg5.entity.VoteEntity;
import com.appdev.contractors.contractorsg5.repository.PostRepository;
import com.appdev.contractors.contractorsg5.repository.VoteRepository;

import jakarta.transaction.Transactional;

import com.appdev.contractors.contractorsg5.repository.CommentsRepository;
import com.appdev.contractors.contractorsg5.repository.FavoritesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Autowired
    private UserService userService;

    // --- CREATE ---
    public PostEntity savePost(PostEntity post) {
        return postRepository.save(post);
    }

    // --- READ BY USER ID ---
    public List<PostEntity> getPostsByUserId(Long userId) {
        return postRepository.findByCreatedBy_UserId(userId);
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
        return postRepository.save(existingPost);
    }

    // --- DELETE ---
    @Transactional
    public void deletePost(Long postId) {
    PostEntity post = getPostById(postId); // throws if not found

    voteRepository.deleteByPost(post);
    commentsRepository.deleteByPost(post);
    favoritesRepository.deleteByPost(post);

    postRepository.delete(post);
}


    // --- VOTE ---
    public PostEntity votePost(Long postId, Long userId, String type) {
        PostEntity post = getPostById(postId);
        UserEntity user = userService.getById(userId);

        VoteEntity vote = voteRepository.findByPostAndUser(post, user).orElse(new VoteEntity());
        boolean isNewVote = vote.getId() == null;

        if (!isNewVote) {
            if (vote.getType().equals(type)) {
                voteRepository.delete(vote); // unvote
            } else {
                vote.setType(type);
                voteRepository.save(vote); // change vote
            }
        } else {
            vote.setPost(post);
            vote.setUser(user);
            vote.setType(type);
            voteRepository.save(vote);
        }

        long upVotes = voteRepository.countByPostAndType(post, "up");
        long downVotes = voteRepository.countByPostAndType(post, "down");
        post.setVotes((int)(upVotes - downVotes));

        return postRepository.save(post);
    }
}
