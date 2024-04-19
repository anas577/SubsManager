package com.example.SubsManagerBackend.dao.Repositories;

import com.example.SubsManagerBackend.dao.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}
