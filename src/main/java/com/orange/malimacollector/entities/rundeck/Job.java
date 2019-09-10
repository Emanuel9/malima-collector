package com.orange.malimacollector.entities.rundeck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {
    private String id;
    private String name;
    private String group;
    private String project;
    private String description;
    private String href;
    private String permalink;
    private boolean scheduled;
    private boolean scheduleEnabled;
    private boolean enabled;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("group")
    public String getGroup() { return group; }
    @JsonProperty("group")
    public void setGroup(String value) { this.group = value; }

    @JsonProperty("project")
    public String getProject() { return project; }
    @JsonProperty("project")
    public void setProject(String value) { this.project = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

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
