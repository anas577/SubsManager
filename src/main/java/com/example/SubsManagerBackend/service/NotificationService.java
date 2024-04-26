package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.Repositories.NotificationRepository;
import com.example.SubsManagerBackend.dao.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class NotificationService implements NotificationManager{
    @Autowired
private NotificationRepository notificationRepository;

    @Override
    public Notification addNotification(Notification notification) {
        try{
            return notificationRepository.save(notification);
        }catch(Exception exception){
            System.out.println(exception);
            return null;
        }
    }

    @Override
    public Notification updateNotification(Notification notification) {
        try{
            return notificationRepository.save(notification);
        }catch(Exception exception){
            System.out.println(exception);
            return null;
        }
    }

    @Override
    public boolean deleteNotification(Notification notification) {
        try{
           notificationRepository.delete(notification);
            return true;
        }catch(Exception exception){
            System.out.println(exception);
            return false;
        }
    }

    @Override
    public boolean deleteNotificationById(Integer id) {
        try{
            notificationRepository.deleteById(id);
            return true;
        }catch(Exception exception){
            System.out.println(exception);
            return false;
        }
    }

    @Override
    public Collection<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification getNotificationById(Integer id) {
        return notificationRepository.findById(id).get();
    }
}
