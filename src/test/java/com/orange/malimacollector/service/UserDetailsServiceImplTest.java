package com.orange.malimacollector.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserDetailsServiceImplTest {
    @Autowired
    UserDetailsServiceImpl service;

    @Test
    void loadUserByUsername() {
        assertNotNull(service.loadUserByUsername("alexm"));
    }
}