package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.Repositories.CategoryRepository;
import com.example.SubsManagerBackend.dao.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class CategoryService implements CategoryManager{
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category addCategory(Category category) {
        try{
            return categoryRepository.save(category);
        }catch(Exception exception){
            System.out.println(exception);
            return null;
        }
    }

    @Override
    public Category updateCategory(Category category) {

        return categoryRepository.save(category);

    }

    @Override
    public boolean deleteCategory(Category category) {
        try{
            categoryRepository.delete(category);
            return true;
        }catch(Exception exception){
            System.out.println(exception);
            return false;
        }
    }

    @Override
    public boolean deleteCategoryById(Integer id) {
        try{
            categoryRepository.deleteById(id);
            return true;
        }catch(Exception exception){
            System.out.println(exception);
            return false;
        }
    }

    @Override
    public Collection<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }


}
