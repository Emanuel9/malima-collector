package com.orange.malimacollector.entities.GitlabEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Permissions {

    private ProjectAccess projectAccess;
    private Object groupAccess;

    @JsonProperty("project_access")
    public ProjectAccess getProjectAccess() { return projectAccess; }
    @JsonProperty("project_access")
    public void setProjectAccess(ProjectAccess value) { this.projectAccess = value; }

    @JsonProperty("group_access")
    public Object getGroupAccess() { return groupAccess; }
    @JsonProperty("group_access")
    public void setGroupAccess(Object value) { this.groupAccess = value; }

}