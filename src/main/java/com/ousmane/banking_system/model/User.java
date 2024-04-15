package com.ousmane.banking_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Column(nullable = false, unique = true)
    private int accountNumber;

    @NotBlank
    @Pattern(regexp = "^\\+?\\d{1,3}[- ]?\\(?\\d{1,3}\\)?[- ]?\\d{3,4}[- ]?\\d{4}$", message = "Invalid phone number format")
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    private boolean enabled;

    @NotBlank
    private String role = "User";

    public User(String firstName, String lastName, int accountNumber, String phoneNumber, String email, String password, boolean enabled, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public @NotBlank String getRole() {
        return role;
    }


    @Override
    public String toString() {
        return "User [first name=" + firstName + ", last name=" + lastName + ", phone number=" + phoneNumber
                + ", email=" + email + ", password=" + password + ", enabled=" + enabled + "]";
    }
}