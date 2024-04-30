package com.example.SubsManagerBackend.web;

import com.example.SubsManagerBackend.dao.entities.Subscription;
import com.example.SubsManagerBackend.service.SubscriptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("subscriptions")
public class SubscriptionController {
    private SubscriptionManager subscriptionManager;
    public SubscriptionController(SubscriptionManager subscriptionManager){
        this.subscriptionManager = subscriptionManager;
    }

    @GetMapping
    public List<Subscription> subscriptionList(){
        return subscriptionManager.getAllSubscriptions();
    }


}
