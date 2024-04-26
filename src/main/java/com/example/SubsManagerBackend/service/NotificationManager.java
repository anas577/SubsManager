package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.entities.Category;
import com.example.SubsManagerBackend.dao.entities.Notification;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component

public interface NotificationManager {
    public Notification addNotification(Notification notification);
    public Notification updateNotification(Notification notification);
    public boolean deleteNotification(Notification notification);
    public boolean deleteNotificationById(Integer id);
    public Collection<Notification> getAllNotifications();
    public Notification getNotificationById(Integer id);
}
