package com.orange.malimacollector.repositories;

import com.orange.malimacollector.entities.User;
import com.orange.malimacollector.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer>{
    UserProfile findByUser(User user);
    UserProfile findByFirstNameAndLastName(String firstName, String lastName);
}