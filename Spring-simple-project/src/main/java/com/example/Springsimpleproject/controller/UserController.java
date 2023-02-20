package com.example.Springsimpleproject.controller;

import com.example.Springsimpleproject.controller.dto.UserDTO;
import com.example.Springsimpleproject.model.entity.User;
import com.example.Springsimpleproject.model.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO save(@RequestBody @Valid UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userService.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        List<User> users = userService.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id , @RequestBody UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User updatedUser = userService.update(id, user);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> findById(@PathVariable Long id) {
        Optional<User> optionalUser = userService.findById(id);
        return optionalUser.map(user -> modelMapper.map(user, UserDTO.class));
    }
}
