package com.example.Springsimpleproject.model.service;

import com.example.Springsimpleproject.model.entity.User;
import com.example.Springsimpleproject.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CacheEvict(value = "users", allEntries = true)
    public User save (User user) {
        return userRepository.save(user);
    }

    @Cacheable(value = "users")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @CacheEvict(value = "users", allEntries = true)
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        userRepository.deleteById(id);
    }

    @CacheEvict(value = "users", allEntries = true)
    public User update(Long id , User user) {
        if (!userRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Cacheable(value = "users", key = "#id")
    public Optional<User> findById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        return userRepository.findById(id);
    }
}
