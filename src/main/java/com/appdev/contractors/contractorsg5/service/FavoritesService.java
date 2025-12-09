package com.appdev.contractors.contractorsg5.service;

import com.appdev.contractors.contractorsg5.entity.FavoritesEntity;
import com.appdev.contractors.contractorsg5.entity.PostEntity;
import com.appdev.contractors.contractorsg5.entity.UserEntity;
import com.appdev.contractors.contractorsg5.repository.FavoritesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesService {

    private final FavoritesRepository repo;
    private final UserService userService;
    private final PostService postService;

    public FavoritesService(FavoritesRepository repo, UserService userService, PostService postService) {
        this.repo = repo;
        this.userService = userService;
        this.postService = postService;
    }

    // --- Add favorite
    public FavoritesEntity saveFavorite(Long userId, Long postId) {
    UserEntity user = userService.getById(userId);
    PostEntity post = postService.getPostById(postId);

    if (user == null || post == null) {
        throw new RuntimeException("User or Post not found");
    }

    Optional<FavoritesEntity> existing = repo.findAll().stream()
            .filter(f -> f.getUser().getUserId().equals(userId) &&
                         f.getPost().getPostId().equals(postId))
            .findFirst();

    if (existing.isPresent()) return existing.get();

    FavoritesEntity fav = new FavoritesEntity(user, post);
    return repo.save(fav);
}


    // --- Get all favorites ---
    public List<FavoritesEntity> getAllFavorites() {
        return repo.findAll();
    }

    // --- Delete by ID ---
    public boolean deleteFavorite(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    // --- Delete by userId & postId ---
    public boolean deleteFavorite(Long userId, Long postId) {
        Optional<FavoritesEntity> fav = repo.findAll().stream()
                .filter(f -> f.getUser().getUserId().equals(userId) && f.getPost().getPostId().equals(postId))
                .findFirst();
        fav.ifPresent(repo::delete);
        return fav.isPresent();
    }
}
