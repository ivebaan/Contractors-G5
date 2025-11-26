package com.appdev.contractors.aytonag5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;

    private String category_name;
    private String description;

    public CategoryEntity() {}

    public CategoryEntity(String category_name, String description) {
        this.category_name = category_name;
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String viewCategoryInfo() {
        return "Category Info:\n" +
               "ID: " + category_id + "\n" +
               "Name: " + category_name + "\n" +
               "Description: " + description;
    }
}
