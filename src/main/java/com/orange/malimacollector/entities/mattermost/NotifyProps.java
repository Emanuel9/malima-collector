package com.orange.malimacollector.entities.mattermost;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotifyProps {
    private String email;
    private String push;
    private String desktop;
    private String desktopSound;
    private String mentionKeys;
    private String channel;
    private String firstName;

    @JsonProperty("email")
    public String getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(String value) { this.email = value; }

    @JsonProperty("push")
    public String getPush() { return push; }
    @JsonProperty("push")
    public void setPush(String value) { this.push = value; }

    @JsonProperty("desktop")
    public String getDesktop() { return desktop; }
    @JsonProperty("desktop")
    public void setDesktop(String value) { this.desktop = value; }

    @JsonProperty("desktop_sound")
    public String getDesktopSound() { return desktopSound; }
    @JsonProperty("desktop_sound")
    public void setDesktopSound(String value) { this.desktopSound = value; }

    @JsonProperty("mention_keys")
    public String getMentionKeys() { return mentionKeys; }
    @JsonProperty("mention_keys")
    public void setMentionKeys(String value) { this.mentionKeys = value; }

    @JsonProperty("channel")
    public String getChannel() { return channel; }
    @JsonProperty("channel")
    public void setChannel(String value) { this.channel = value; }

    @JsonProperty("first_name")
    public String getFirstName() { return firstName; }
    @JsonProperty("first_name")
    public void setFirstName(String value) { this.firstName = value; }
}
