package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.entities.Category;
import com.example.SubsManagerBackend.dao.entities.Provider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProviderManager {
    public Provider addProvider(Provider provider);
    public Provider editProvider(Provider provider);
    public boolean deleteProvider(Provider provider);
    public boolean deleteProviderById(Integer id);
    public List<Provider> getAllProviders();

    public Provider getProviderById(Integer id);
    public List<Provider> getProvidersByCategory(Category category);


}
