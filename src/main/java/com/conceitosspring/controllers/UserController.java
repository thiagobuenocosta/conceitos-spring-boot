package com.conceitosspring.controllers;

import com.conceitosspring.model.User;
import com.conceitosspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> usersList() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}/filter")
    public User userFilterById(@PathVariable("id") Long id) {
        Optional<User> userFound = userRepository.findById(id);
        if (userFound.isPresent())
            return userFound.get();

        return null;
    }

    @PostMapping("/")
    public User userAdd(@RequestBody User user) {
        return this.userRepository.save(user);
    }

}
