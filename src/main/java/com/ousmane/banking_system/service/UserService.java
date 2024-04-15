package com.ousmane.banking_system.service;

import com.ousmane.banking_system.model.User;
import com.ousmane.banking_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByAccountNumber(int accountNumber) {
        return userRepository.findByAccountNumber(accountNumber);
    }

    public boolean doesUserExistByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean doesUserExistByAccountNumber(int accountNumber) {
        return userRepository.existsByAccountNumber(accountNumber);
    }

    public List<User> getAllEnabledUsers() {
        return userRepository.findByEnabledTrue();
    }

    public List<User> getAllDisabledUsers() {
        return userRepository.findByEnabledFalse();
    }

    public List<User> getUsersByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public List<User> getUsersByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public List<User> getUsersByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }
}
