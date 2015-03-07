package com.hockeystreamsgradle.api;

/**
 * Created by sean on 3/7/15.
 */
public class StreamInfo {
    private String type;
    private String src;
    private String location;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
