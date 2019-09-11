package com.orange.malimacollector.entities.mattermost;

import com.fasterxml.jackson.annotation.*;
import com.orange.malimacollector.entities.CommonFields;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post extends CommonFields {
    private long editAt;
    private String channelID;
    private String rootID;
    private String originalID;
    private String message;
    private String type;
    private Props props;
    private String hashtag;
    private String[] filenames;
    private String[] fileIDS;
    private String pendingPostID;
    private Metadata metadata;

    @JsonProperty("edit_at")
    public long getEditAt() { return editAt; }
    @JsonProperty("edit_at")
    public void setEditAt(long value) { this.editAt = value; }

    @JsonProperty("channel_id")
    public String getChannelID() { return channelID; }
    @JsonProperty("channel_id")
    public void setChannelID(String value) { this.channelID = value; }

    @JsonProperty("root_id")
    public String getRootID() { return rootID; }
    @JsonProperty("root_id")
    public void setRootID(String value) { this.rootID = value; }

    @JsonProperty("original_id")
    public String getOriginalID() { return originalID; }
    @JsonProperty("original_id")
    public void setOriginalID(String value) { this.originalID = value; }

    @JsonProperty("message")
    public String getMessage() { return message; }
    @JsonProperty("message")
    public void setMessage(String value) { this.message = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("props")
    public Props getProps() { return props; }
    @JsonProperty("props")
    public void setProps(Props value) { this.props = value; }

    @JsonProperty("hashtag")
    public String getHashtag() { return hashtag; }
    @JsonProperty("hashtag")
    public void setHashtag(String value) { this.hashtag = value; }

    @JsonProperty("filenames")
    public String[] getFilenames() { return filenames; }
    @JsonProperty("filenames")
    public void setFilenames(String[] value) { this.filenames = value; }

    @JsonProperty("file_ids")
    public String[] getFileIDS() { return fileIDS; }
    @JsonProperty("file_ids")
    public void setFileIDS(String[] value) { this.fileIDS = value; }

    @JsonProperty("pending_post_id")
    public String getPendingPostID() { return pendingPostID; }
    @JsonProperty("pending_post_id")
    public void setPendingPostID(String value) { this.pendingPostID = value; }

    @JsonProperty("metadata")
    public Metadata getMetadata() { return metadata; }
    @JsonProperty("metadata")
    public void setMetadata(Metadata value) { this.metadata = value; }
}

