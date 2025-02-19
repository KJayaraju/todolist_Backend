package com.jayaraju.todolist.service;

import com.jayaraju.todolist.entity.User;
import com.jayaraju.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by username
    public User getUserByUsername(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    public Optional<User> login(String email, String password) {
        // Find the user by email
        Optional<User> user = userRepository.findByEmail(email);

        // Check if the user exists and if the password matches (plaintext comparison)
        if (user.isPresent() && password.equals(user.get().getPassword())) {
            return user; // Return the user data if passwords match
        }

        return Optional.empty(); // Return empty if credentials are invalid
    }

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
