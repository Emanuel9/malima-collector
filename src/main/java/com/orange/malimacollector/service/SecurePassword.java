package com.orange.malimacollector.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurePassword {
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}