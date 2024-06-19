package com.example.SubsManagerBackend.dao.Repositories;

import com.example.SubsManagerBackend.dao.entities.Subscription;
import com.example.SubsManagerBackend.dao.entities.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    List<Subscription> findByStatus(SubscriptionStatus subscriptionStatus);
}
