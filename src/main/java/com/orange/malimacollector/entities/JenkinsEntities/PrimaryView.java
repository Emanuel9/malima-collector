package com.orange.malimacollector.entities.JenkinsEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrimaryView {
    private String primaryViewClass;
    private String name;
    private String url;
    private String color;

    @JsonProperty("_class")
    public String getPrimaryViewClass() { return primaryViewClass; }
    @JsonProperty("_class")
    public void setPrimaryViewClass(String value) { this.primaryViewClass = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("color")
    public String getColor() { return color; }
    @JsonProperty("color")
    public void setColor(String value) { this.color = value; }
}
