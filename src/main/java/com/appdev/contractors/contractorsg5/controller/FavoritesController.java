package com.appdev.contractors.contractorsg5.controller;

import com.appdev.contractors.contractorsg5.entity.FavoritesEntity;
import com.appdev.contractors.contractorsg5.service.FavoritesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    private final FavoritesService service;

    public FavoritesController(FavoritesService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public FavoritesEntity addFavorite(@RequestBody FavoritesEntity fav) {
        return service.saveFavorite(fav);
    }

    @GetMapping("/getAll")
    public List<FavoritesEntity> getFavorites() {
        return service.getAllFavorites();
    }

    @GetMapping("/get/{id}")
    public FavoritesEntity getFavoriteById(@PathVariable Long id) {
        return service.getFavoriteById(id);
    }

    @PutMapping("/update/{id}")
    public FavoritesEntity updateFavorite(@PathVariable Long id, @RequestBody FavoritesEntity fav) {
        return service.updateFavorite(id, fav);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFavorite(@PathVariable Long id) {
        boolean deleted = service.deleteFavorite(id);
        return deleted ? "Deleted" : "Not Found";
    }
}