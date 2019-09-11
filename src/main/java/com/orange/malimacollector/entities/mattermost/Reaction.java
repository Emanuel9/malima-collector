package com.orange.malimacollector.entities.mattermost;

import com.fasterxml.jackson.annotation.*;
import com.orange.malimacollector.entities.CommonFields;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reaction extends CommonFields {
    private String emojiName;

    @JsonProperty("emoji_name")
    public String getEmojiName() { return emojiName; }
    @JsonProperty("emoji_name")
    public void setEmojiName(String value) { this.emojiName = value; }
}
