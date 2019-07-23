package com.orange.malimacollector.entities.MattermostEntities;

import com.fasterxml.jackson.annotation.*;

public class Post {
    private String id;
    private long createAt;
    private long updateAt;
    private long deleteAt;
    private long editAt;
    private String userID;
    private String channelID;
    private String rootID;
    private String parentID;
    private String originalID;
    private String message;
    private String type;
    private Props props;
    private String hashtag;
    private String[] filenames;
    private String[] fileIDS;
    private String pendingPostID;
    private Metadata metadata;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("create_at")
    public long getCreateAt() { return createAt; }
    @JsonProperty("create_at")
    public void setCreateAt(long value) { this.createAt = value; }

    @JsonProperty("update_at")
    public long getUpdateAt() { return updateAt; }
    @JsonProperty("update_at")
    public void setUpdateAt(long value) { this.updateAt = value; }

    @JsonProperty("delete_at")
    public long getDeleteAt() { return deleteAt; }
    @JsonProperty("delete_at")
    public void setDeleteAt(long value) { this.deleteAt = value; }

    @JsonProperty("edit_at")
    public long getEditAt() { return editAt; }
    @JsonProperty("edit_at")
    public void setEditAt(long value) { this.editAt = value; }

    @JsonProperty("user_id")
    public String getUserID() { return userID; }
    @JsonProperty("user_id")
    public void setUserID(String value) { this.userID = value; }

    @JsonProperty("channel_id")
    public String getChannelID() { return channelID; }
    @JsonProperty("channel_id")
    public void setChannelID(String value) { this.channelID = value; }

    @JsonProperty("root_id")
    public String getRootID() { return rootID; }
    @JsonProperty("root_id")
    public void setRootID(String value) { this.rootID = value; }

    @JsonProperty("parent_id")
    public String getParentID() { return parentID; }
    @JsonProperty("parent_id")
    public void setParentID(String value) { this.parentID = value; }

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

