package com.orange.malimacollector.entities.sonar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rule {
    private String key;
    private String name;
    private String status;
    private String lang;
    private String langName;

    @JsonProperty("key")
    public String getKey() { return key; }
    @JsonProperty("key")
    public void setKey(String value) { this.key = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("status")
    public String getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("lang")
    public String getLang() { return lang; }
    @JsonProperty("lang")
    public void setLang(String value) { this.lang = value; }

    @JsonProperty("langName")
    public String getLangName() { return langName; }
    @JsonProperty("langName")
    public void setLangName(String value) { this.langName = value; }
}
