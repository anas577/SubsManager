package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.Repositories.ProviderRepository;
import com.example.SubsManagerBackend.dao.entities.Category;
import com.example.SubsManagerBackend.dao.entities.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService implements ProviderManager{
    @Autowired
    public ProviderRepository providerRepository;

    @Override
    public Provider addProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public Provider editProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public boolean deleteProvider(Provider provider) {
        try{
            providerRepository.delete(provider);
            return true;
        }catch(Exception exception){
            return false;
        }
    }

    @Override
    public boolean deleteProviderById(Integer id) {
        try{
            providerRepository.deleteById(id);
            return true;
        }catch(Exception exception){
            return false;
        }
    }

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @Override
    public Provider getProviderById(Integer id) {
        return providerRepository.findById(id).get();
    }

    @Override
    public List<Provider> getProvidersByCategory(Category category) {
        return providerRepository.findAllByCategory(category);
    }
}
