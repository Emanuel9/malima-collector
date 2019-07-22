package com.orange.malimacollector.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {
    private long id;
    private String webURL;
    private String name;
    private String path;
    private String description;
    private String visibility;
    private boolean lfsEnabled;
    private Object avatarURL;
    private boolean requestAccessEnabled;
    private String fullName;
    private String fullPath;
    private Object parentID;
    private Object[] projects;
    private Object[] sharedProjects;
    private Object ldapCN;
    private Object ldapAccess;
    private Object sharedRunnersMinutesLimit;
    private Object extraSharedRunnersMinutesLimit;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("web_url")
    public String getWebURL() { return webURL; }
    @JsonProperty("web_url")
    public void setWebURL(String value) { this.webURL = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("path")
    public String getPath() { return path; }
    @JsonProperty("path")
    public void setPath(String value) { this.path = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("visibility")
    public String getVisibility() { return visibility; }
    @JsonProperty("visibility")
    public void setVisibility(String value) { this.visibility = value; }

    @JsonProperty("lfs_enabled")
    public boolean getLFSEnabled() { return lfsEnabled; }
    @JsonProperty("lfs_enabled")
    public void setLFSEnabled(boolean value) { this.lfsEnabled = value; }

    @JsonProperty("avatar_url")
    public Object getAvatarURL() { return avatarURL; }
    @JsonProperty("avatar_url")
    public void setAvatarURL(Object value) { this.avatarURL = value; }

    @JsonProperty("request_access_enabled")
    public boolean getRequestAccessEnabled() { return requestAccessEnabled; }
    @JsonProperty("request_access_enabled")
    public void setRequestAccessEnabled(boolean value) { this.requestAccessEnabled = value; }

    @JsonProperty("full_name")
    public String getFullName() { return fullName; }
    @JsonProperty("full_name")
    public void setFullName(String value) { this.fullName = value; }

    @JsonProperty("full_path")
    public String getFullPath() { return fullPath; }
    @JsonProperty("full_path")
    public void setFullPath(String value) { this.fullPath = value; }

    @JsonProperty("parent_id")
    public Object getParentID() { return parentID; }
    @JsonProperty("parent_id")
    public void setParentID(Object value) { this.parentID = value; }

    @JsonProperty("projects")
    public Object[] getProjects() { return projects; }
    @JsonProperty("projects")
    public void setProjects(Object[] value) { this.projects = value; }

    @JsonProperty("shared_projects")
    public Object[] getSharedProjects() { return sharedProjects; }
    @JsonProperty("shared_projects")
    public void setSharedProjects(Object[] value) { this.sharedProjects = value; }

    @JsonProperty("ldap_cn")
    public Object getLDAPCN() { return ldapCN; }
    @JsonProperty("ldap_cn")
    public void setLDAPCN(Object value) { this.ldapCN = value; }

    @JsonProperty("ldap_access")
    public Object getLDAPAccess() { return ldapAccess; }
    @JsonProperty("ldap_access")
    public void setLDAPAccess(Object value) { this.ldapAccess = value; }

    @JsonProperty("shared_runners_minutes_limit")
    public Object getSharedRunnersMinutesLimit() { return sharedRunnersMinutesLimit; }
    @JsonProperty("shared_runners_minutes_limit")
    public void setSharedRunnersMinutesLimit(Object value) { this.sharedRunnersMinutesLimit = value; }

    @JsonProperty("extra_shared_runners_minutes_limit")
    public Object getExtraSharedRunnersMinutesLimit() { return extraSharedRunnersMinutesLimit; }
    @JsonProperty("extra_shared_runners_minutes_limit")
    public void setExtraSharedRunnersMinutesLimit(Object value) { this.extraSharedRunnersMinutesLimit = value; }
}
