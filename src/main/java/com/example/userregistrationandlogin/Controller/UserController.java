package com.example.userregistrationandlogin.Controller;

import com.example.userregistrationandlogin.Model.User;
import com.example.userregistrationandlogin.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String>registerUser(@RequestParam String username, @RequestParam String password){
        User registeredUser = userService.registerUser(username, password);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String>loginUser(@RequestParam String username, @RequestParam String password) {
        User loggedInUser = userService.loginUser(username, password);
        if (loggedInUser != null) {
        return ResponseEntity.ok("User logged in successfully");
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed. Invalid username or password.");
        }


}}
