package com.ousmane.banking_system.repository;

import com.ousmane.banking_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByAccountNumber(int accountNumber);
    boolean existsByEmail(String email);
    boolean existsByAccountNumber(int accountNumber);
    List<User> findByEnabledTrue();
    List<User> findByEnabledFalse();
    List<User> findByLastName(String lastName);
    List<User> findByFirstName(String firstName);
    List<User> findByPhoneNumber(String phoneNumber);
}
