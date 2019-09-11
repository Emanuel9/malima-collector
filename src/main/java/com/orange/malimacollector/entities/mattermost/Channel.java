package com.orange.malimacollector.entities.mattermost;

import com.fasterxml.jackson.annotation.*;
import com.orange.malimacollector.entities.CommonFields;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel extends CommonFields {
    private String teamID;
    private String type;
    private String header;
    private String purpose;
    private long lastPostAt;
    private long totalMsgCount;
    private long extraUpdateAt;
    private String creatorID;

    @JsonProperty("team_id")
    public String getTeamID() { return teamID; }
    @JsonProperty("team_id")
    public void setTeamID(String value) { this.teamID = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

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

