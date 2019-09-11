package com.orange.malimacollector.dao;

import com.orange.malimacollector.entities.login.AppUser;
import com.orange.malimacollector.model.AppUserForm;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppUserDAOTest {
    @Autowired
    AppUserDAO appUserDAO;

    AppUser alex = new AppUser(1L, "alexm",
            "$2a$10$lE7Z0WQsFNcPpWKRWDaL7OyCDQKUEG//apO1zuf/KWz/pvXK/kFGK", "alexmcn07@gmail.com", true);

    @Test
    void getMaxUserIdTest() {
        Long maxUser = 2L;
        assertEquals(maxUser, appUserDAO.getMaxUserId());
    }

    @Test
    void findAppUserByUserNameTest() {
        assertEquals(alex.getUserName(), appUserDAO.findAppUserByUserName("alexm").getUserName());
    }

    @Test
    void findAppUserByEmailTest() {
        assertEquals(alex.getEmail(), appUserDAO.findAppUserByEmail("alexmcn07@gmail.com").getEmail());
    }

    @Test
    void getAppUsersTest() {
        List<AppUser> users = asList(alex);
        assertEquals(users.get(0).getUserName(), appUserDAO.getAppUsers().get(0).getUserName());
    }

    @Test
    void createAppUserTest() {
        AppUserForm alexCopy = new AppUserForm(2L, "alexmaic", false,
                "alexmcn10@gmail.com", "test", "test");

        AppUser user = new AppUser(alexCopy.getUserId(), alexCopy.getUserName(),
                "$2a$10$lE7Z0WQsFNcPpWKRWDaL7OyCDQKUEG//apO1zuf/KWz/pvXK/kFGK",
                alexCopy.getEmail(), false);
        assertEquals(user.getUserName(), appUserDAO.createAppUser(alexCopy).getUserName());
    }

    @Test
    void getRoleNamesTest() {
        assertEquals("ROLE_ADMIN", appUserDAO.getRoleNames(alex.getUserId()));
    }
}