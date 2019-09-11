package com.orange.malimacollector.entities.mattermost;

import com.fasterxml.jackson.annotation.*;
import com.orange.malimacollector.entities.CommonFields;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Teams extends CommonFields {
    private String email;
    private String type;
    private String allowedDomains;
    private String inviteID;
    private boolean allowOpenInvite;

    @JsonProperty("email")
    public String getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(String value) { this.email = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("allowed_domains")
    public String getAllowedDomains() { return allowedDomains; }
    @JsonProperty("allowed_domains")
    public void setAllowedDomains(String value) { this.allowedDomains = value; }

    @JsonProperty("invite_id")
    public String getInviteID() { return inviteID; }
    @JsonProperty("invite_id")
    public void setInviteID(String value) { this.inviteID = value; }

    @JsonProperty("allow_open_invite")
    public boolean getAllowOpenInvite() { return allowOpenInvite; }
    @JsonProperty("allow_open_invite")
    public void setAllowOpenInvite(boolean value) { this.allowOpenInvite = value; }
}
