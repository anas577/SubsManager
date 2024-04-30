package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.Repositories.UserRepository;
import com.example.SubsManagerBackend.dao.entities.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class UserService implements UserManager{

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
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
}
