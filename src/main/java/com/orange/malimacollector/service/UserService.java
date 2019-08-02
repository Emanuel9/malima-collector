package com.orange.malimacollector.service;

import com.orange.malimacollector.entities.User;
import com.orange.malimacollector.model.Roles;
import com.orange.malimacollector.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private SecurePassword securePassword;

    public User saveUser(User user){
        User userOptional = userRepository.findByEmail(user.getEmail());
        if( userOptional != null ){
            return userOptional;
        }

        if( user.getRole() == null ){
            user.setRole(Roles.ROLE_USER);
        }
        user.setPassword(securePassword.passwordEncoder().encode(user.getPassword()));

        try {
            user = userRepository.saveAndFlush(user);
        }catch (Exception ex){}

        return user;
    }
}