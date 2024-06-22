package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.Repositories.UserRepository;
import com.example.SubsManagerBackend.dao.entities.Role;
import com.example.SubsManagerBackend.dao.entities.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserManager{
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;

    /*public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }*/




    @Override
    public User addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(User user) {
        try {
            userRepository.delete(user);
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public boolean deleteUserById(Integer id) {
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

}
