package com.prevoty.smartfilter.client;

public class InfoResult {
    public int maximum;
    public int used;
    public int remaining;
    public String message;

    public InfoResult(int maximum, int used, int remaining, String message) {
        this.maximum = maximum;
        this.used = used;
        this.remaining = remaining;
        this.message = message;
    }
}
