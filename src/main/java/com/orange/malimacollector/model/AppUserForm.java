package com.orange.malimacollector.model;

public class AppUserForm {

    private Long userId;
    private String userName;
    private boolean enabled;
    private String email;
    private String password;
    private String confirmPassword;

    public AppUserForm() {

    }

    public AppUserForm(Long userId, String userName, //
                        boolean enabled, String email, String password, String confirmPassword) {
        this.userId = userId;
        this.userName = userName;
        this.enabled = enabled;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}