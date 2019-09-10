package com.orange.malimacollector.entities.jira;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    private String self;
    private String id;
    private String key;
    private String name;
    private AvatarUrls avatarUrls;
    private ProjectCategory projectCategory;

    @JsonProperty("self")
    public String getSelf() { return self; }
    @JsonProperty("self")
    public void setSelf(String value) { this.self = value; }

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("key")
    public String getKey() { return key; }
    @JsonProperty("key")
    public void setKey(String value) { this.key = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("avatarUrls")
    public AvatarUrls getAvatarUrls() { return avatarUrls; }
    @JsonProperty("avatarUrls")
    public void setAvatarUrls(AvatarUrls value) { this.avatarUrls = value; }

    @JsonProperty("projectCategory")
    public ProjectCategory getProjectCategory() { return projectCategory; }
    @JsonProperty("projectCategory")
    public void setProjectCategory(ProjectCategory value) { this.projectCategory = value; }
}

