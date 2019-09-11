package com.orange.malimacollector.entities.jira;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orange.malimacollector.entities.CommonFields;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project extends CommonFields {
    private AvatarUrls avatarUrls;
    private ProjectCategory projectCategory;

    @JsonProperty("avatarUrls")
    public AvatarUrls getAvatarUrls() { return avatarUrls; }
    @JsonProperty("avatarUrls")
    public void setAvatarUrls(AvatarUrls value) { this.avatarUrls = value; }

    @JsonProperty("projectCategory")
    public ProjectCategory getProjectCategory() { return projectCategory; }
    @JsonProperty("projectCategory")
    public void setProjectCategory(ProjectCategory value) { this.projectCategory = value; }
}

