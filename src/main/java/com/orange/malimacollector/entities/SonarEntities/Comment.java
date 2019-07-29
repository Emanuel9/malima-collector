package com.orange.malimacollector.entities.SonarEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    private String key;
    private String login;
    private String htmlText;
    private String markdown;
    private boolean updatable;
    private String createdAt;

    @JsonProperty("key")
    public String getKey() { return key; }
    @JsonProperty("key")
    public void setKey(String value) { this.key = value; }

    @JsonProperty("login")
    public String getLogin() { return login; }
    @JsonProperty("login")
    public void setLogin(String value) { this.login = value; }

    @JsonProperty("htmlText")
    public String getHTMLText() { return htmlText; }
    @JsonProperty("htmlText")
    public void setHTMLText(String value) { this.htmlText = value; }

    @JsonProperty("markdown")
    public String getMarkdown() { return markdown; }
    @JsonProperty("markdown")
    public void setMarkdown(String value) { this.markdown = value; }

    @JsonProperty("updatable")
    public boolean getUpdatable() { return updatable; }
    @JsonProperty("updatable")
    public void setUpdatable(boolean value) { this.updatable = value; }

    @JsonProperty("createdAt")
    public String getCreatedAt() { return createdAt; }
    @JsonProperty("createdAt")
    public void setCreatedAt(String value) { this.createdAt = value; }
}
