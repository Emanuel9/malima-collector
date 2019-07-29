package com.orange.malimacollector.entities.SonarEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    private Paging paging;
    private Component[] components;

    @JsonProperty("paging")
    public Paging getPaging() { return paging; }
    @JsonProperty("paging")
    public void setPaging(Paging value) { this.paging = value; }

    @JsonProperty("components")
    public Component[] getComponents() { return components; }
    @JsonProperty("components")
    public void setComponents(Component[] value) { this.components = value; }
}
