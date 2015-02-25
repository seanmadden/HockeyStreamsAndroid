package com.hockeystreamsgradle.api;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sean on 2/22/15.
 */
public class GetLiveResponse {
    String status;
    List<LiveGame> schedule;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<LiveGame> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<LiveGame> schedule) {
        this.schedule = schedule;
    }
}
