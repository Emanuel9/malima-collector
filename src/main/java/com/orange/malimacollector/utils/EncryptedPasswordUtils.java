package com.orange.malimacollector.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtils {
    private static final Logger logger = LoggerFactory.getLogger(EncryptedPasswordUtils.class);

    public static String encryptedPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "test";
        String encryptedPassword = encryptedPassword(password);

        logger.info("Encrypted Password: " + encryptedPassword);
    }

}
