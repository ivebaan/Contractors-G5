package com.appdev.contractors.contractorsg5.service;

import com.appdev.contractors.contractorsg5.entity.FavoritesEntity;
import com.appdev.contractors.contractorsg5.repository.FavoritesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesService {

    private final FavoritesRepository repo;

    public FavoritesService(FavoritesRepository repo) {
        this.repo = repo;
    }

    // Create
    public FavoritesEntity saveFavorite(FavoritesEntity fav) {
        return repo.save(fav);
    }

    // Read All
    public List<FavoritesEntity> getAllFavorites() {
        return repo.findAll();
    }

    // Read by ID
    public FavoritesEntity getFavoriteById(Long id) {
        Optional<FavoritesEntity> opt = repo.findById(id);
        return opt.orElseThrow(() ->
                new IllegalArgumentException("Favorite with id " + id + " not found")
        );
    }

    // Update
    public FavoritesEntity updateFavorite(Long id, FavoritesEntity updated) {
        FavoritesEntity existing = getFavoriteById(id);
        existing.setUser(updated.getUser());
        existing.setPost(updated.getPost());
        existing.setDateAdded(updated.getDateAdded());
        return repo.save(existing);
    }

    // Delete
    public boolean deleteFavorite(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
    // List by User ID
    public List<FavoritesEntity> getFavoritesByUserId(int userId) {
        return repo.findAll().stream()
                .filter(fav -> fav.getUser().getUserId() == userId)
                .toList();
    }
}
    
