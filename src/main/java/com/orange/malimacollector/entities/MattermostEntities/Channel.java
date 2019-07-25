package com.orange.malimacollector.entities.MattermostEntities;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {
    private String id;
    private long createAt;
    private long updateAt;
    private long deleteAt;
    private String teamID;
    private String type;
    private String displayName;
    private String name;
    private String header;
    private String purpose;
    private long lastPostAt;
    private long totalMsgCount;
    private long extraUpdateAt;
    private String creatorID;

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

    @JsonProperty("team_id")
    public String getTeamID() { return teamID; }
    @JsonProperty("team_id")
    public void setTeamID(String value) { this.teamID = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("display_name")
    public String getDisplayName() { return displayName; }
    @JsonProperty("display_name")
    public void setDisplayName(String value) { this.displayName = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("header")
    public String getHeader() { return header; }
    @JsonProperty("header")
    public void setHeader(String value) { this.header = value; }

    @JsonProperty("purpose")
    public String getPurpose() { return purpose; }
    @JsonProperty("purpose")
    public void setPurpose(String value) { this.purpose = value; }

    @JsonProperty("last_post_at")
    public long getLastPostAt() { return lastPostAt; }
    @JsonProperty("last_post_at")
    public void setLastPostAt(long value) { this.lastPostAt = value; }

    @JsonProperty("total_msg_count")
    public long getTotalMsgCount() { return totalMsgCount; }
    @JsonProperty("total_msg_count")
    public void setTotalMsgCount(long value) { this.totalMsgCount = value; }

    @JsonProperty("extra_update_at")
    public long getExtraUpdateAt() { return extraUpdateAt; }
    @JsonProperty("extra_update_at")
    public void setExtraUpdateAt(long value) { this.extraUpdateAt = value; }

    @JsonProperty("creator_id")
    public String getCreatorID() { return creatorID; }
    @JsonProperty("creator_id")
    public void setCreatorID(String value) { this.creatorID = value; }
}

