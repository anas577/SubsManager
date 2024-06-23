package com.example.SubsManagerBackend.web;

import com.example.SubsManagerBackend.dao.entities.Provider;
import com.example.SubsManagerBackend.dao.entities.Subscription;
import com.example.SubsManagerBackend.dao.entities.SubscriptionStatus;
import com.example.SubsManagerBackend.dao.entities.User;
import com.example.SubsManagerBackend.service.ProviderManager;
import com.example.SubsManagerBackend.service.SubscriptionManager;
import com.example.SubsManagerBackend.service.UserManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subscriptions")
public class SubscriptionController {
    private SubscriptionManager subscriptionManager;
    private UserManager userManager;
    private ProviderManager providerManager;
    public SubscriptionController(SubscriptionManager subscriptionManager,UserManager userManager,ProviderManager providerManager){
        this.subscriptionManager = subscriptionManager;
        this.userManager = userManager;
        this.providerManager = providerManager;
    }

    @GetMapping
    public List<Subscription> subscriptionList(){
        return subscriptionManager.getSubscriptionsForCurrentUser();
    }

    @GetMapping("/{id}")
    public Subscription subscription(@PathVariable Integer id){
        return subscriptionManager.getSubscriptionById(id);
    }

    @PostMapping
    public Subscription createSubscription(@RequestBody Subscription subscription){
        User user = userManager.getUserById(subscription.getUser().getId());
        Provider provider = providerManager.getProviderById(subscription.getProvider().getId());
        subscription.setUser(user);
        subscription.setProvider(provider);
        return subscriptionManager.addSubscription(subscription);
    }

    @PatchMapping("/{id}")
    public Subscription updateSubscription(@RequestBody Subscription subscription, @PathVariable Integer id){
        Subscription updatedSubscription = subscriptionManager.getSubscriptionById(id);
        updatedSubscription.setPlan(subscription.getPlan());
        updatedSubscription.setPaymentCost(subscription.getPaymentCost());
        updatedSubscription.setStartDate(subscription.getStartDate());
        updatedSubscription.setStatus(subscription.getStatus());
        updatedSubscription.setRenewalFrequency(subscription.getRenewalFrequency());
        return subscriptionManager.editSubscription(updatedSubscription);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable Integer id){
        subscriptionManager.removeSubscriptionById(id);
    }

    @PutMapping("/changeStatus/{id}")
    public Subscription changeSubscriptionStatus(@PathVariable Integer id){
        Subscription subscription = subscriptionManager.getSubscriptionById(id);
        if(subscription.getStatus().equals(SubscriptionStatus.ACTIVE)){
            subscription.setStatus(SubscriptionStatus.INACTIVE);
        }else{
            subscription.setStatus(SubscriptionStatus.ACTIVE);
        }
        return subscriptionManager.editSubscription(subscription);
    }

}
