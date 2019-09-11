package com.orange.malimacollector.entities.gitlab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orange.malimacollector.entities.CommonFields;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Group extends CommonFields {
    private String visibility;
    private boolean lfsEnabled;
    private boolean requestAccessEnabled;
    private String fullName;
    private Object[] projects;
    private Object[] sharedProjects;
    private Object ldapCN;
    private Object ldapAccess;
    private Object sharedRunnersMinutesLimit;
    private Object extraSharedRunnersMinutesLimit;

    @JsonProperty("visibility")
    public String getVisibility() { return visibility; }
    @JsonProperty("visibility")
    public void setVisibility(String value) { this.visibility = value; }

    @JsonProperty("lfs_enabled")
    public boolean getLFSEnabled() { return lfsEnabled; }
    @JsonProperty("lfs_enabled")
    public void setLFSEnabled(boolean value) { this.lfsEnabled = value; }

    @JsonProperty("request_access_enabled")
    public boolean getRequestAccessEnabled() { return requestAccessEnabled; }
    @JsonProperty("request_access_enabled")
    public void setRequestAccessEnabled(boolean value) { this.requestAccessEnabled = value; }

    @JsonProperty("full_name")
    public String getFullName() { return fullName; }
    @JsonProperty("full_name")
    public void setFullName(String value) { this.fullName = value; }

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
