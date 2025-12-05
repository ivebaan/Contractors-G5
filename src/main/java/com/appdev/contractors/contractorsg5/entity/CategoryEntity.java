package com.appdev.contractors.contractorsg5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    private String categoryName;
    private String description;

    public CategoryEntity() {}

    public CategoryEntity(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public int getCategory_id() {
        return categoryId;
    }

    public void setCategory_id(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory_name() {
        return categoryName;
    }

    public void setCategory_name(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String viewCategoryInfo() {
        return "Category Info:\n" +
               "ID: " + categoryId + "\n" +
               "Name: " + categoryName + "\n" +
               "Description: " + description;
    }
}
