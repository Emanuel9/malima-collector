package com.orange.malimacollector.service;

import com.orange.malimacollector.dao.AppUserDAO;
import com.orange.malimacollector.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserDAO appUserDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserDAO.findAppUserByUserName(userName);

        if (appUser == null) {
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        String roleName = this.appUserDAO.getRoleNames(appUser.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleName != null) {
            GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
            grantList.add(authority);
        }

        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(),
                appUser.getEncryptedPassword(), grantList);

        return userDetails;
    }

}
