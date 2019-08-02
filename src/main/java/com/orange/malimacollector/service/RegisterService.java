package com.orange.malimacollector.service;

import com.orange.malimacollector.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserService userService;

    public User addUser(User user) {
        User userToBeReturned = new User();
        userToBeReturned = userService.saveUser(user);
        return userToBeReturned;
    }
}
