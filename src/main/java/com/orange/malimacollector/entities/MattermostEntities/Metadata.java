package com.orange.malimacollector.entities.MattermostEntities;

import com.fasterxml.jackson.annotation.*;

public class Metadata {
    private Embed[] embeds;
    private Emoji[] emojis;
    private File[] files;
    private Props images;
    private Reaction[] reactions;

    @JsonProperty("embeds")
    public Embed[] getEmbeds() { return embeds; }
    @JsonProperty("embeds")
    public void setEmbeds(Embed[] value) { this.embeds = value; }

    @JsonProperty("emojis")
    public Emoji[] getEmojis() { return emojis; }
    @JsonProperty("emojis")
    public void setEmojis(Emoji[] value) { this.emojis = value; }

    @JsonProperty("files")
    public File[] getFiles() { return files; }
    @JsonProperty("files")
    public void setFiles(File[] value) { this.files = value; }

    @JsonProperty("images")
    public Props getImages() { return images; }
    @JsonProperty("images")
    public void setImages(Props value) { this.images = value; }

    @JsonProperty("reactions")
    public Reaction[] getReactions() { return reactions; }
    @JsonProperty("reactions")
    public void setReactions(Reaction[] value) { this.reactions = value; }
}

