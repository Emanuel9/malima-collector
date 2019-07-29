package com.orange.malimacollector.entities.SonarEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TextRange {
    private long startLine;
    private long endLine;
    private long startOffset;
    private long endOffset;

    @JsonProperty("startLine")
    public long getStartLine() { return startLine; }
    @JsonProperty("startLine")
    public void setStartLine(long value) { this.startLine = value; }

    @JsonProperty("endLine")
    public long getEndLine() { return endLine; }
    @JsonProperty("endLine")
    public void setEndLine(long value) { this.endLine = value; }

    @JsonProperty("startOffset")
    public long getStartOffset() { return startOffset; }
    @JsonProperty("startOffset")
    public void setStartOffset(long value) { this.startOffset = value; }

    @JsonProperty("endOffset")
    public long getEndOffset() { return endOffset; }
    @JsonProperty("endOffset")
    public void setEndOffset(long value) { this.endOffset = value; }
}
