package com.orange.malimacollector.entities.MattermostEntities;

import com.fasterxml.jackson.annotation.*;

public class Emoji {
    private String id;
    private String creatorID;
    private String name;
    private long createAt;
    private long updateAt;
    private long deleteAt;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("creator_id")
    public String getCreatorID() { return creatorID; }
    @JsonProperty("creator_id")
    public void setCreatorID(String value) { this.creatorID = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

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
}

