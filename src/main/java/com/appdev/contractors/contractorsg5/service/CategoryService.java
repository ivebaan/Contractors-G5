package com.appdev.contractors.contractorsg5.service;

import com.appdev.contractors.contractorsg5.entity.CategoryEntity;
import com.appdev.contractors.contractorsg5.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity saveCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    public CategoryEntity getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
