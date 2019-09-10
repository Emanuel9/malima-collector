package com.orange.malimacollector.entities.sonar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String login;
    private String name;
    private boolean active;
    private String avatar;

    @JsonProperty("login")
    public String getLogin() { return login; }
    @JsonProperty("login")
    public void setLogin(String value) { this.login = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("active")
    public boolean getActive() { return active; }
    @JsonProperty("active")
    public void setActive(boolean value) { this.active = value; }

    @JsonProperty("avatar")
    public String getAvatar() { return avatar; }
    @JsonProperty("avatar")
    public void setAvatar(String value) { this.avatar = value; }
}
