package com.orange.malimacollector.entities.mattermost;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Embed {
    private String type;
    private String url;
    private Props data;

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("data")
    public Props getData() { return data; }
    @JsonProperty("data")
    public void setData(Props value) { this.data = value; }
}

