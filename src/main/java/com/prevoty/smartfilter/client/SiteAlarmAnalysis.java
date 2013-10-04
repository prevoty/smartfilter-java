package com.prevoty.smartfilter.client;

import java.util.ArrayList;
import java.util.HashMap;

public class SiteAlarmAnalysis {
    public String scan_id;
    public Integer customer_id;
    public String url;
    public SiteAlarmAnalysisCounters analysis_counters;
    public SiteAlarmBaseline expected_baseline;
    public SiteAlarmDeviationReport deviation_report;
    public ArrayList<SiteAlarmScreenshot> screenshots;
    public ArrayList<SiteAlarmBrowserEvent> browser_events;
    public HashMap<String, ArrayList<String>> dns_records;
    public SiteAlarmHtmlDocument html_document;
    public String created;
}
