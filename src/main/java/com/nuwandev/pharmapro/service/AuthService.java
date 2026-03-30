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
        if (!PasswordUtil.checkPassword(password, user.passwordHash())) {
            return Optional.empty();
        }

        return Optional.of(user);
    }

    public Optional<User> findByRememberMeToken(String token) {
        if (token == null || token.isBlank()) return Optional.empty();
        return userRepository.findByRememberMeToken(token.trim());
    }

    public void updateRememberMeToken(Long userId, String token) {
        userRepository.updateRememberMeToken(userId, token);
    }
}
