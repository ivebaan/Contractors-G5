package com.appdev.contractors.aytonag5.controller;

import com.appdev.contractors.aytonag5.entity.CategoryEntity;
import com.appdev.contractors.aytonag5.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryEntity getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return "Category with ID " + id + " has been deleted.";
    }
}
