package com.prevoty.smartfilter.client;

public class FilterResult {
    public String message;
    public String output;
    public FilterStatistics statistics;

    public FilterResult(String message, String output, FilterStatistics statistics) {
        this.message = message;
        this.output = output;
        this.statistics = statistics;
    }
}