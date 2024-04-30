package com.example.SubsManagerBackend.web;

import com.example.SubsManagerBackend.dao.entities.Category;
import com.example.SubsManagerBackend.dao.entities.Provider;
import com.example.SubsManagerBackend.service.CategoryManager;
import com.example.SubsManagerBackend.service.ProviderManager;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping("/providers")
public class ProviderController {
    public ProviderManager providerManager;
    public CategoryManager categoryManager;

    public ProviderController(ProviderManager providerManager, CategoryManager categoryManager){
        this.providerManager = providerManager;
        this.categoryManager = categoryManager;
    }

    @GetMapping
    public List<Provider> providerList(){
        return providerManager.getAllProviders();
    }

    @GetMapping("/{id}")
    public Provider provider(@PathVariable Integer id){
        return providerManager.getProviderById(id);
    }

    @PostMapping
    public Provider createProvider(@RequestBody Provider provider){
        Category category = categoryManager.getCategoryById(provider.getCategory().getId());
        if(category == null){
            return null;
        }
        provider.setCategory(category);
        return providerManager.addProvider(provider);

    }

}
