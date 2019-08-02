package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.User;
import com.orange.malimacollector.entities.UserProfile;
import com.orange.malimacollector.repositories.UserProfileRepository;
import com.orange.malimacollector.repositories.UserRepository;
import com.orange.malimacollector.service.UserProfileService;
import com.orange.malimacollector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserProfileController {
    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;

    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    public String profilePage( Model model ){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = null;
        UserProfile userProfile = null;
        if ( authentication != null ) {
            user = (User) authentication.getPrincipal();
            User optionalUser = userRepository.findByEmail(user.getEmail());
            if(optionalUser != null){
                user = optionalUser;
            }
            model.addAttribute("user", user);
        }

        UserProfile optionalUserProfile = userProfileRepository.findByUser(user);

        if(optionalUserProfile != null){
            userProfile = optionalUserProfile;
        }else{
            userProfile = new UserProfile();
            userProfile.setUser(user);
        }
        model.addAttribute("profileToEdit", userProfile);

        return "profile";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profile/edit")
    public String editProfilePage( Model model ){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = null;
        UserProfile userProfile = null;
        if ( authentication != null ) {
            user = (User) authentication.getPrincipal();
            User optionalUser = userRepository.findByEmail(user.getEmail());
            if(optionalUser != null){
                user = optionalUser;
            }
            model.addAttribute("user", user);
        }

        UserProfile optionalUserProfile = userProfileRepository.findByUser(user);

        if(optionalUserProfile != null){
            userProfile = optionalUserProfile;

        }else{
            userProfile = new UserProfile();
            userProfile.setUser(user);
        }

        model.addAttribute("profileToEdit", userProfile);

        return "editProfile";
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/profile/edit")
    public String editUserProfile(@ModelAttribute UserProfile profileToEdit,
                                  Model model){

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        User user = null;
        if ( authentication != null ) {
            user = (User) authentication.getPrincipal();

            User optionalUser = userRepository.findByEmail(user.getEmail());
            if (optionalUser != null) {
                user = optionalUser;
            }
        }


        UserProfile optionalUserProfile = userProfileRepository.findByUser(user);
        UserProfile userProfile = optionalUserProfile;

        userProfile.setFirstName(profileToEdit.getFirstName());
        userProfile.setLastName(profileToEdit.getLastName());
        userProfile.setBio(profileToEdit.getBio());

        try {
            userProfileService.updateUserProfile(userProfile);
        }catch(Exception ex){}

        model.addAttribute("user",user);
        model.addAttribute("profileToEdit", userProfile);
        return "profile";
    }

}
