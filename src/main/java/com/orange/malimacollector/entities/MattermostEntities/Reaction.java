package com.orange.malimacollector.entities.MattermostEntities;

import com.fasterxml.jackson.annotation.*;

public class Reaction {
    private String userID;
    private String postID;
    private String emojiName;
    private long createAt;

    @JsonProperty("user_id")
    public String getUserID() { return userID; }
    @JsonProperty("user_id")
    public void setUserID(String value) { this.userID = value; }

    @JsonProperty("post_id")
    public String getPostID() { return postID; }
    @JsonProperty("post_id")
    public void setPostID(String value) { this.postID = value; }

    @JsonProperty("emoji_name")
    public String getEmojiName() { return emojiName; }
    @JsonProperty("emoji_name")
    public void setEmojiName(String value) { this.emojiName = value; }

    @JsonProperty("create_at")
    public long getCreateAt() { return createAt; }
    @JsonProperty("create_at")
    public void setCreateAt(long value) { this.createAt = value; }
}
