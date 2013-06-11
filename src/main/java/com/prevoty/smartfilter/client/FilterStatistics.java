package com.prevoty.smartfilter.client;

public class FilterStatistics {
    public int invalid_attributes = 0;
    public int invalid_protocols = 0;
    public int invalid_tags = 0;
    public int javascript_attributes = 0;
    public int javascript_protocols = 0;
    public int javascript_tags = 0;
    public int tags_balanced = 0;
    public int transformations = 0;

    public FilterStatistics(int invalid_attributes, int invalid_protocols, int invalid_tags, int javascript_attributes, int javascript_protocols, int javascript_tags, int tags_balanced, int transformations) {
        this.invalid_attributes = invalid_attributes;
        this.invalid_protocols = invalid_protocols;
        this.invalid_tags = invalid_tags;
        this.javascript_attributes = javascript_attributes;
        this.javascript_protocols = javascript_protocols;
        this.javascript_tags = javascript_tags;
        this.tags_balanced = tags_balanced;
        this.transformations = transformations;
    }
}
