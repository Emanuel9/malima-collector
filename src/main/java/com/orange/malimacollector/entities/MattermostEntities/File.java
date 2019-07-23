package com.orange.malimacollector.entities.MattermostEntities;

import com.fasterxml.jackson.annotation.*;

public class File {
    private String id;
    private String userID;
    private String postID;
    private long createAt;
    private long updateAt;
    private long deleteAt;
    private String name;
    private String extension;
    private long size;
    private String mimeType;
    private long width;
    private long height;
    private boolean hasPreviewImage;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("user_id")
    public String getUserID() { return userID; }
    @JsonProperty("user_id")
    public void setUserID(String value) { this.userID = value; }

    @JsonProperty("post_id")
    public String getPostID() { return postID; }
    @JsonProperty("post_id")
    public void setPostID(String value) { this.postID = value; }

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

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("extension")
    public String getExtension() { return extension; }
    @JsonProperty("extension")
    public void setExtension(String value) { this.extension = value; }

    @JsonProperty("size")
    public long getSize() { return size; }
    @JsonProperty("size")
    public void setSize(long value) { this.size = value; }

    @JsonProperty("mime_type")
    public String getMIMEType() { return mimeType; }
    @JsonProperty("mime_type")
    public void setMIMEType(String value) { this.mimeType = value; }

    @JsonProperty("width")
    public long getWidth() { return width; }
    @JsonProperty("width")
    public void setWidth(long value) { this.width = value; }

    @JsonProperty("height")
    public long getHeight() { return height; }
    @JsonProperty("height")
    public void setHeight(long value) { this.height = value; }

    @JsonProperty("has_preview_image")
    public boolean getHasPreviewImage() { return hasPreviewImage; }
    @JsonProperty("has_preview_image")
    public void setHasPreviewImage(boolean value) { this.hasPreviewImage = value; }
}

