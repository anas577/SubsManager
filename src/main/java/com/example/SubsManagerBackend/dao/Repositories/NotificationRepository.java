package com.example.SubsManagerBackend.dao.Repositories;

import com.example.SubsManagerBackend.dao.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
