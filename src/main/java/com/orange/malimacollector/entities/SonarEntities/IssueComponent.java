package com.orange.malimacollector.entities.SonarEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueComponent {
    private String key;
    private boolean enabled;
    private String qualifier;
    private String name;
    private String longName;
    private String path;

    @JsonProperty("key")
    public String getKey() { return key; }
    @JsonProperty("key")
    public void setKey(String value) { this.key = value; }

    @JsonProperty("enabled")
    public boolean getEnabled() { return enabled; }
    @JsonProperty("enabled")
    public void setEnabled(boolean value) { this.enabled = value; }

    @JsonProperty("qualifier")
    public String getQualifier() { return qualifier; }
    @JsonProperty("qualifier")
    public void setQualifier(String value) { this.qualifier = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("longName")
    public String getLongName() { return longName; }
    @JsonProperty("longName")
    public void setLongName(String value) { this.longName = value; }

    @JsonProperty("path")
    public String getPath() { return path; }
    @JsonProperty("path")
    public void setPath(String value) { this.path = value; }
}
