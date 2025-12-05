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

    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public CategoryEntity updateCategory(Long id, CategoryEntity newCategory) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(newCategory.getName());
            category.setDescription(newCategory.getDescription());
            return categoryRepository.save(category);
        }).orElse(null);
    }


    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
