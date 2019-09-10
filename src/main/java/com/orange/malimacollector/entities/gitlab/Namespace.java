package com.orange.malimacollector.entities.gitlab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Namespace {
    private long id;
    private String name;
    private String path;
    private String kind;
    private String fullPath;
    private Object parentID;
    private String avatarURL;
    private String webURL;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("path")
    public String getPath() { return path; }
    @JsonProperty("path")
    public void setPath(String value) { this.path = value; }

    @JsonProperty("kind")
    public String getKind() { return kind; }
    @JsonProperty("kind")
    public void setKind(String value) { this.kind = value; }

    @JsonProperty("full_path")
    public String getFullPath() { return fullPath; }
    @JsonProperty("full_path")
    public void setFullPath(String value) { this.fullPath = value; }

    @JsonProperty("parent_id")
    public Object getParentID() { return parentID; }
    @JsonProperty("parent_id")
    public void setParentID(Object value) { this.parentID = value; }

    @JsonProperty("avatar_url")
    public String getAvatarURL() { return avatarURL; }
    @JsonProperty("avatar_url")
    public void setAvatarURL(String value) { this.avatarURL = value; }

    @JsonProperty("web_url")
    public String getWebURL() { return webURL; }
    @JsonProperty("web_url")
    public void setWebURL(String value) { this.webURL = value; }
}
