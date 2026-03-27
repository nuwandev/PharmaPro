package com.nuwandev.pharmapro.service;

import com.nuwandev.pharmapro.model.User;
import com.nuwandev.pharmapro.repository.UserRepository;

import java.util.Optional;

public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> login(String username, String password) {
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            return Optional.empty();
        }

        Optional<User> userOpt = userRepository.findByUsername(username.trim());
        if (userOpt.isEmpty()) return Optional.empty();

        User user = userOpt.get();
        // In a real application, use a secure password hashing mechanism
        if (!password.equals(user.passwordHash())) {
            return Optional.empty();
        }

        return Optional.of(user);
    }
}
