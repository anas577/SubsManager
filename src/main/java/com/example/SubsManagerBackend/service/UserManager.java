package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.entities.Category;
import com.example.SubsManagerBackend.dao.entities.User;

import java.util.Collection;

public interface UserManager {
    public User addUser(User user);
    public User updateUser(User user);
    public boolean deleteUser(User user);
    public boolean deleteUserById(Integer id);
    public Collection<User> getAllUsers();
    public User getUserById(Integer id);
    public User getUserByUsername(String username);
}
