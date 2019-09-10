package com.orange.malimacollector.entities.mattermost;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Teams {
    private String id;
    private long createAt;
    private long updateAt;
    private long deleteAt;
    private String displayName;
    private String name;
    private String description;
    private String email;
    private String type;
    private String allowedDomains;
    private String inviteID;
    private boolean allowOpenInvite;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("create_at")
    public long getCreateAt() { return createAt; }
    @JsonProperty("create_at")
    public void setCreateAt(long value) { this.createAt = value; }

    @JsonProperty("update_at")
    public long getUpdateAt() { return updateAt; }
    @JsonProperty("update_at")
    public void setUpdateAt(long value) { this.updateAt = value; }

    @JsonProperty("delete_at")
    public long getDeleteAt() { return deleteAt; }
    @JsonProperty("delete_at")
    public void setDeleteAt(long value) { this.deleteAt = value; }

    @JsonProperty("display_name")
    public String getDisplayName() { return displayName; }
    @JsonProperty("display_name")
    public void setDisplayName(String value) { this.displayName = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

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
