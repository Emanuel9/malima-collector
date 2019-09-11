package com.orange.malimacollector.entities.sonar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orange.malimacollector.entities.CommonFields;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rule extends CommonFields {
    private String status;
    private String lang;
    private String langName;

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
