package com.example.userregistrationandlogin.Service;

import com.example.userregistrationandlogin.Exception.UserAlreadyExistsException;
import com.example.userregistrationandlogin.Exception.UserNotFoundException;
import com.example.userregistrationandlogin.Model.User;
import com.example.userregistrationandlogin.Repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {
    @Autowired
    private final UserRepository userRepository;


    public User registerUser(String username, String password){
        if (userRepository.findByUsername(username) != null) {
            throw new UserAlreadyExistsException("Username is already taken");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return userRepository.save(user);
    }

    public User loginUser(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user ==null || !user.getPassword().equals(password)){
            throw new UserNotFoundException("Invalid username or password.");
        }
        return user;
    }




    }

