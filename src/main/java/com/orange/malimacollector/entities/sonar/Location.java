package com.orange.malimacollector.entities.sonar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private TextRange textRange;
    private String msg;

    @JsonProperty("textRange")
    public TextRange getTextRange() { return textRange; }
    @JsonProperty("textRange")
    public void setTextRange(TextRange value) { this.textRange = value; }

    @JsonProperty("msg")
    public String getMsg() { return msg; }
    @JsonProperty("msg")
    public void setMsg(String value) { this.msg = value; }
}
