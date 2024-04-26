package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.entities.Category;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public interface CategoryManager {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public boolean deleteCategory(Category category);
    public boolean deleteCategoryById(Integer id);
    public Collection<Category> getAllCategories();
    public Category getCategoryById(Integer id);
}
