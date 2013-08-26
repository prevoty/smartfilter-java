package com.prevoty.smartfilter.client;

import java.util.ArrayList;

public class UrlInformation {
    public String url = "";
    public String completed = "";
    public String message = "";
    public ArrayList<String> javascript_redirects = new ArrayList<String>();
    public ArrayList<String> client_redirects = new ArrayList<String>();
    public ArrayList<String> server_redirects = new ArrayList<String>();
    public ArrayList<String> popups = new ArrayList<String>();
    public ArrayList<String> downloads = new ArrayList<String>();

    public UrlInformation(String url, String completed, String message, ArrayList<String> javascript_redirects, ArrayList<String> client_redirects, ArrayList<String> server_redirects, ArrayList<String> popups, ArrayList<String> downloads) {
        this.url = url;
        this.completed = completed;
        this.message = message;
        this.javascript_redirects = javascript_redirects;
        this.client_redirects = client_redirects;
        this.server_redirects = server_redirects;
        this.popups = popups;
        this.downloads = downloads;
    }
}
