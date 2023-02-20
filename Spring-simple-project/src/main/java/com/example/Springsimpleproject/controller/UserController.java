package com.example.Springsimpleproject.controller;

import com.example.Springsimpleproject.model.entity.User;
import com.example.Springsimpleproject.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody @Valid User user) {
        return userService.save(user);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id , @RequestBody User user) {
        return userService.update(id,user);
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
