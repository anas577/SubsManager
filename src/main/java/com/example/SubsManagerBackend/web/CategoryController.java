package com.example.SubsManagerBackend.web;

import com.example.SubsManagerBackend.dao.entities.Category;
import com.example.SubsManagerBackend.service.CategoryManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryManager categoryManager;

    public CategoryController(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

    @GetMapping
    public Collection<Category> getAllCategories(){
        return categoryManager.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        return categoryManager.getCategoryById(id);
    }
    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryManager.addCategory(category);
    }

}
