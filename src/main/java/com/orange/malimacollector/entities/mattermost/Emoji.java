package com.orange.malimacollector.entities.mattermost;

import com.fasterxml.jackson.annotation.*;
import com.orange.malimacollector.entities.CommonFields;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Emoji extends CommonFields {
    private String creatorID;

    @JsonProperty("creator_id")
    public String getCreatorID() { return creatorID; }
    @JsonProperty("creator_id")
    public void setCreatorID(String value) { this.creatorID = value; }
}

