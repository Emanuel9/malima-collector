package com.orange.malimacollector.entities.mattermost;

import com.fasterxml.jackson.annotation.*;
import com.orange.malimacollector.entities.CommonFields;

@JsonIgnoreProperties(ignoreUnknown = true)
public class File extends CommonFields {
    private String extension;
    private long size;
    private String mimeType;
    private long width;
    private long height;
    private boolean hasPreviewImage;

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

