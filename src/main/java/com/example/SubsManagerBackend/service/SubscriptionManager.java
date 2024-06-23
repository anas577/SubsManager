package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.entities.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SubscriptionManager {
    public Subscription addSubscription(Subscription subscription);
    public Subscription editSubscription(Subscription subscription);
    public boolean removeSubscription(Subscription subscription);
    public boolean removeSubscriptionById(Integer id);
    public List<Subscription> getAllSubscriptions();
    public Subscription getSubscriptionById(Integer id);
    public List<Subscription> getSubscriptionsForCurrentUser();

}
