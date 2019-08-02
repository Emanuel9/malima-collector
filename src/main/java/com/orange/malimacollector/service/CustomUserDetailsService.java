package com.orange.malimacollector.service;

import com.orange.malimacollector.entities.User;
import com.orange.malimacollector.model.CustomUserDetails;
import com.orange.malimacollector.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User optionalUser = userRepository.findByEmail(email);

        if (optionalUser == null) {
            throw new UsernameNotFoundException("Username was not found!");
        }

        Optional<User> convertedUser = Optional.of(optionalUser);
        return convertedUser
                .map(CustomUserDetails::new)
                .get();
    }

}
