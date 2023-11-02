package com.example.userregistrationandlogin.Repository;

import com.example.userregistrationandlogin.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findByUsernameIgnoreCase(String username);



}
