package com.orange.malimacollector.entities.ConfluenceEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {
    private Result[] results;
    private long start;
    private long limit;
    private long size;
    private PageLinks links;

    @JsonProperty("results")
    public Result[] getResults() { return results; }
    @JsonProperty("results")
    public void setResults(Result[] value) { this.results = value; }

    @JsonProperty("start")
    public long getStart() { return start; }
    @JsonProperty("start")
    public void setStart(long value) { this.start = value; }

    @JsonProperty("limit")
    public long getLimit() { return limit; }
    @JsonProperty("limit")
    public void setLimit(long value) { this.limit = value; }

    @JsonProperty("size")
    public long getSize() { return size; }
    @JsonProperty("size")
    public void setSize(long value) { this.size = value; }

    @JsonProperty("_links")
    public PageLinks getLinks() { return links; }
    @JsonProperty("_links")
    public void setLinks(PageLinks value) { this.links = value; }
}
