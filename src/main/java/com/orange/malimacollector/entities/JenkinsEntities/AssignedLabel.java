package com.orange.malimacollector.entities.JenkinsEntities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignedLabel {
    private String name;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }
}
