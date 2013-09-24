package com.prevoty.smartfilter.client;

public class SiteAlarmEvent {
    public Integer tab_id = 0;
    public String event_name = "";
    public String event_value = "";
    public String timestamp = "";
    public String mime_type = "";

    public SiteAlarmEvent(Integer tab_id, String event_name, String event_value, String timestamp, String mime_type) {
        this.tab_id = tab_id;
        this.event_name = event_name;
        this.event_value = event_value;
        this.timestamp = timestamp;
        this.mime_type = mime_type;
    }
}
