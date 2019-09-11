package com.orange.malimacollector.entities.rundeck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orange.malimacollector.entities.CommonFields;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Job extends CommonFields {
    private String group;
    private String project;
    private String href;
    private String permalink;
    private boolean scheduled;
    private boolean scheduleEnabled;
    private boolean enabled;

    @JsonProperty("group")
    public String getGroup() { return group; }
    @JsonProperty("group")
    public void setGroup(String value) { this.group = value; }

    @JsonProperty("project")
    public String getProject() { return project; }
    @JsonProperty("project")
    public void setProject(String value) { this.project = value; }

    @JsonProperty("href")
    public String getHref() { return href; }
    @JsonProperty("href")
    public void setHref(String value) { this.href = value; }

    @JsonProperty("permalink")
    public String getPermalink() { return permalink; }
    @JsonProperty("permalink")
    public void setPermalink(String value) { this.permalink = value; }

    @JsonProperty("scheduled")
    public boolean getScheduled() { return scheduled; }
    @JsonProperty("scheduled")
    public void setScheduled(boolean value) { this.scheduled = value; }

    @JsonProperty("scheduleEnabled")
    public boolean getScheduleEnabled() { return scheduleEnabled; }
    @JsonProperty("scheduleEnabled")
    public void setScheduleEnabled(boolean value) { this.scheduleEnabled = value; }

    @JsonProperty("enabled")
    public boolean getEnabled() { return enabled; }
    @JsonProperty("enabled")
    public void setEnabled(boolean value) { this.enabled = value; }
}
