package com.prevoty.smartfilter.client;

import java.util.ArrayList;

public class SiteAlarmDeviationReport {
    public ArrayList<SiteAlarmDeviation> html_document_changed;
    public ArrayList<SiteAlarmDeviation> html_document_removed;
    public ArrayList<SiteAlarmDeviation> dns_records_removed;
    public ArrayList<SiteAlarmDeviation> dns_records_added;
    public ArrayList<SiteAlarmDeviation> new_browser_events;
    public ArrayList<SiteAlarmDeviation> failed_browser_events;
}
