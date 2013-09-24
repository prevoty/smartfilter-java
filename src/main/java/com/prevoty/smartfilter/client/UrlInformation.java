package com.prevoty.smartfilter.client;

public class UrlInformation {
    public SiteAlarmAnalysis analysis;
    public String message = "";

    public UrlInformation(SiteAlarmAnalysis siteAlarmAnalysis, String message) {
        this.analysis = siteAlarmAnalysis;
        this.message = message;
    }
}
