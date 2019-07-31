package com.orange.malimacollector.entities.ConfluenceEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.criterion.Restrictions;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    private String id;
    private Type type;
    private Status status;
    private String title;
    private Restrictions restrictions;
    private ResultLinks links;
    private Expandable expandable;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("type")
    public Type getType() { return type; }
    @JsonProperty("type")
    public void setType(Type value) { this.type = value; }

    @JsonProperty("status")
    public Status getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(Status value) { this.status = value; }

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("restrictions")
    public Restrictions getRestrictions() { return restrictions; }
    @JsonProperty("restrictions")
    public void setRestrictions(Restrictions value) { this.restrictions = value; }

    @JsonProperty("_links")
    public ResultLinks getLinks() { return links; }
    @JsonProperty("_links")
    public void setLinks(ResultLinks value) { this.links = value; }

    @JsonProperty("_expandable")
    public Expandable getExpandable() { return expandable; }
    @JsonProperty("_expandable")
    public void setExpandable(Expandable value) { this.expandable = value; }
}

