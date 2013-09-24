package com.prevoty.smartfilter.client;

import java.util.ArrayList;

public class SiteAlarmAnalysis {
    public String scan_id = "";
    public Integer customer_id = 0;
    public String url = "";
    public Boolean baseline_deviation = false;
    public Integer javascript_redirects = 0;
    public Integer client_redirects = 0;
    public Integer server_redirects = 0;
    public Integer popups = 0;
    public Integer downloads = 0;
    public ArrayList<SiteAlarmScreenshot> screenshots = new ArrayList<SiteAlarmScreenshot>();
    public ArrayList<SiteAlarmEvent> events = new ArrayList<SiteAlarmEvent>();
    public String created = "";

    public SiteAlarmAnalysis(String scan_id, Integer customer_id) {
        this.scan_id= scan_id;
        this.customer_id = customer_id;
    }
}
