package com.orange.malimacollector.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_profile")
public class UserProfile{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userProfileId;

    @OneToOne
    private User user;

    private String bio;

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    public UserProfile() {
    }

    public Integer getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Integer userProfileId) {
        this.userProfileId = userProfileId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return firstName;
    }
}