package com.ousmane.banking_system.controller;

import com.ousmane.banking_system.model.User;
import com.ousmane.banking_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<User> getUserByAccountNumber(@PathVariable int accountNumber) {
        Optional<User> user = userService.getUserByAccountNumber(accountNumber);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/enabled")
    public ResponseEntity<List<User>> getAllEnabledUsers() {
        List<User> users = userService.getAllEnabledUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/disabled")
    public ResponseEntity<List<User>> getAllDisabledUsers() {
        List<User> users = userService.getAllDisabledUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<User>> getUsersByLastName(@PathVariable String lastName) {
        List<User> users = userService.getUsersByLastName(lastName);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/firstname/{firstName}")
    public ResponseEntity<List<User>> getUsersByFirstName(@PathVariable String firstName) {
        List<User> users = userService.getUsersByFirstName(firstName);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/phonenumber/{phoneNumber}")
    public ResponseEntity<List<User>> getUsersByPhoneNumber(@PathVariable String phoneNumber) {
        List<User> users = userService.getUsersByPhoneNumber(phoneNumber);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
