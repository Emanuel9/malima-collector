package com.orange.malimacollector.entities.confluence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Expandable {
    private String container;
    private String metadata;
    private String extensions;
    private String operations;
    private String children;
    private String history;
    private String ancestors;
    private String body;
    private String version;
    private String descendants;
    private Space space;

    @JsonProperty("container")
    public String getContainer() { return container; }
    @JsonProperty("container")
    public void setContainer(String value) { this.container = value; }

    @JsonProperty("metadata")
    public String getMetadata() { return metadata; }
    @JsonProperty("metadata")
    public void setMetadata(String value) { this.metadata = value; }

    @JsonProperty("extensions")
    public String getExtensions() { return extensions; }
    @JsonProperty("extensions")
    public void setExtensions(String value) { this.extensions = value; }

    @JsonProperty("operations")
    public String getOperations() { return operations; }
    @JsonProperty("operations")
    public void setOperations(String value) { this.operations = value; }

    @JsonProperty("children")
    public String getChildren() { return children; }
    @JsonProperty("children")
    public void setChildren(String value) { this.children = value; }

    @JsonProperty("history")
    public String getHistory() { return history; }
    @JsonProperty("history")
    public void setHistory(String value) { this.history = value; }

    @JsonProperty("ancestors")
    public String getAncestors() { return ancestors; }
    @JsonProperty("ancestors")
    public void setAncestors(String value) { this.ancestors = value; }

    @JsonProperty("body")
    public String getBody() { return body; }
    @JsonProperty("body")
    public void setBody(String value) { this.body = value; }

    @JsonProperty("version")
    public String getVersion() { return version; }
    @JsonProperty("version")
    public void setVersion(String value) { this.version = value; }

    @JsonProperty("descendants")
    public String getDescendants() { return descendants; }
    @JsonProperty("descendants")
    public void setDescendants(String value) { this.descendants = value; }

    @JsonProperty("space")
    public Space getSpace() { return space; }
    @JsonProperty("space")
    public void setSpace(Space value) { this.space = value; }
}
