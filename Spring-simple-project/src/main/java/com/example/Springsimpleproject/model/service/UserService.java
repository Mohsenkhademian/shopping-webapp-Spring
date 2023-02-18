package com.example.Springsimpleproject.model.service;

import com.example.Springsimpleproject.model.entity.User;
import com.example.Springsimpleproject.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public User save (User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        userRepository.deleteById(id);
    }

    public User update(Long id , User user) {
        if (!userRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        return userRepository.findById(id);
    }
}
