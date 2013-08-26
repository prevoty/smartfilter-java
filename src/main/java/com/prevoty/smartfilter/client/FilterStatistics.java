package com.prevoty.smartfilter.client;

import java.util.HashMap;

public class FilterStatistics {
    public int invalid_attributes = 0;
    public int invalid_protocols = 0;
    public int invalid_tags = 0;
    public int blacklisted_phrases = 0;
    public int flagged_phrases = 0;
    public int javascript_attributes = 0;
    public int javascript_protocols = 0;
    public int javascript_tags = 0;
    public int prevoty_profanity_features = 0;
    public int prevoty_spam_features = 0;
    public HashMap<String,String> prevoty_link_metadata = new HashMap<String, String>();
    public int tags_balanced = 0;
    public int transformations = 0;

    public FilterStatistics(int invalid_attributes, int invalid_protocols, int invalid_tags, int blacklisted_phrases, int flagged_phrases, int javascript_attributes, int javascript_protocols, int javascript_tags, int prevoty_profanity_features, int prevoty_spam_features, HashMap<String, String> prevoty_link_metadata, int tags_balanced, int transformations) {
        this.invalid_attributes = invalid_attributes;
        this.invalid_protocols = invalid_protocols;
        this.invalid_tags = invalid_tags;
        this.blacklisted_phrases = blacklisted_phrases;
        this.flagged_phrases = flagged_phrases;
        this.javascript_attributes = javascript_attributes;
        this.javascript_protocols = javascript_protocols;
        this.javascript_tags = javascript_tags;
        this.prevoty_profanity_features = prevoty_profanity_features;
        this.prevoty_spam_features = prevoty_spam_features;
        this.prevoty_link_metadata = prevoty_link_metadata;
        this.tags_balanced = tags_balanced;
        this.transformations = transformations;
    }
}
