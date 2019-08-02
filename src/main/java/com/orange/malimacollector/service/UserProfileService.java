package com.orange.malimacollector.service;

import com.orange.malimacollector.entities.User;
import com.orange.malimacollector.entities.UserProfile;
import com.orange.malimacollector.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;


    public UserProfile showAnonymousName() {
        UserProfile optionalUserProfile2 = userProfileRepository.findByFirstNameAndLastName("Anonymous", "Anonymous");
        UserProfile userProfile = new UserProfile();
        if (optionalUserProfile2 != null) {
            userProfile = optionalUserProfile2;
        } else {
            userProfile = new UserProfile();
            User user = new User();
            user.setEmail("dummy@dummy.com");
            user.setPassword(" ");
            userProfile.setFirstName("Anonymous");
            userProfile.setLastName("Anonymous");
            userProfile.setUser(user);
            userService.saveUser(user);
            userProfileService.saveUserProfile(userProfile);
        }
        return userProfile;
    }

    public UserProfile saveUserProfile(UserProfile userProfile){
        UserProfile optionalUserProfile;
        optionalUserProfile = checkIfProfileExists(userProfile);
        if(optionalUserProfile != null){
            return optionalUserProfile;
        }
        return userProfileRepository.saveAndFlush(userProfile);
    }

    public UserProfile updateUserProfile (UserProfile userProfile) throws Exception {

        UserProfile optionalUserProfile;
        optionalUserProfile = checkIfProfileExists(userProfile);

        if(optionalUserProfile == null){
            throw new Exception("Cannot update a profile that does not exist!");
        }
        return userProfileRepository.saveAndFlush(userProfile);
    }

    private UserProfile checkIfProfileExists(UserProfile userProfile){

        return userProfileRepository.findByUser(userProfile.getUser());
    }

    public UserProfile createNewUserProfile(User user){
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(user);
        return saveUserProfile(userProfile);
    }

}
