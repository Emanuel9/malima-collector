package com.orange.malimacollector.entities.sonar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Component {
    private String organization;
    private String id;
    private String key;
    private String name;
    private String qualifier;
    private String visibility;
    private String lastAnalysisDate;
    private String revision;

    @JsonProperty("organization")
    public String getOrganization() { return organization; }
    @JsonProperty("organization")
    public void setOrganization(String value) { this.organization = value; }

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

    @JsonProperty("qualifier")
    public String getQualifier() { return qualifier; }
    @JsonProperty("qualifier")
    public void setQualifier(String value) { this.qualifier = value; }

    @JsonProperty("visibility")
    public String getVisibility() { return visibility; }
    @JsonProperty("visibility")
    public void setVisibility(String value) { this.visibility = value; }

    @JsonProperty("lastAnalysisDate")
    public String getLastAnalysisDate() { return lastAnalysisDate; }
    @JsonProperty("lastAnalysisDate")
    public void setLastAnalysisDate(String value) { this.lastAnalysisDate = value; }

    @JsonProperty("revision")
    public String getRevision() { return revision; }
    @JsonProperty("revision")
    public void setRevision(String value) { this.revision = value; }
}
