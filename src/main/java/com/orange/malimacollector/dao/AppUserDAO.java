package com.orange.malimacollector.dao;

import com.orange.malimacollector.entities.AppRole;
import com.orange.malimacollector.entities.AppUser;
import com.orange.malimacollector.model.AppUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.*;

@Repository
@Transactional
public class AppUserDAO {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Map<Long, AppUser> USERS_MAP = new HashMap<>();
    private static final Map<Long, AppRole> ROLE_MAP = new HashMap<>();

    static {
        initDATA();
    }

    private static void initDATA(){
        String encryptedPassword = "$2a$10$lE7Z0WQsFNcPpWKRWDaL7OyCDQKUEG//apO1zuf/KWz/pvXK/kFGK";

        AppUser alexm = new AppUser(1L, "alexm", encryptedPassword, "alexmcn07@gmail.com", true);
        AppRole role = new AppRole("ROLE_ADMIN");

        USERS_MAP.put(alexm.getUserId(), alexm);
        ROLE_MAP.put(alexm.getUserId(), role);
    }

    public Long getMaxUserId() {
        long max = 0;
        for (Long id : USERS_MAP.keySet()) {
            if (id > max) {
                max = id;
            }
        }
        return max;
    }

    public AppUser findAppUserByUserName(String userName) {
        Collection<AppUser> appUsers = USERS_MAP.values();
        for (AppUser u : appUsers) {
            if (u.getUserName().equals(userName)) {
                return u;
            }
        }
        return null;
    }

    public AppUser findAppUserByEmail(String email) {
        Collection<AppUser> appUsers = USERS_MAP.values();
        for (AppUser u : appUsers) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public List<AppUser> getAppUsers() {
        List<AppUser> list = new ArrayList<>();

        list.addAll(USERS_MAP.values());
        return list;
    }

    public AppUser createAppUser(AppUserForm form) {
        Long userId = this.getMaxUserId() + 1;
        String encryptedPassword = this.passwordEncoder.encode(form.getPassword());

        AppUser user = new AppUser(userId, form.getUserName(),
                encryptedPassword, form.getEmail(), false);
        AppRole role = new AppRole("ROLE_USER");

        USERS_MAP.put(userId, user);
        ROLE_MAP.put(userId, role);
        return user;
    }

    public String getRoleNames(Long userId) {
        return ROLE_MAP.get(userId).getRoleName();
    }
}
