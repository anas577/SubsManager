package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.Repositories.SubscriptionRepository;
import com.example.SubsManagerBackend.dao.entities.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService implements SubscriptionManager{
    @Autowired
    public SubscriptionRepository subscriptionRepository;
    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription editSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public boolean removeSubscription(Subscription subscription) {
        try{
            subscriptionRepository.delete(subscription);
            return true;
        }catch(Exception exception){
            return false;
        }
    }

    @Override
    public boolean removeSubscriptionById(Integer id) {
        try{
            subscriptionRepository.deleteById(id);
            return true;
        }catch(Exception exception){
            return false;
        }
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription getSubscriptionById(Integer id) {
        return subscriptionRepository.findById(id).get();
    }
}
