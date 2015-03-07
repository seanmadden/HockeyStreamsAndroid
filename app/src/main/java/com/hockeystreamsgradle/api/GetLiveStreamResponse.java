package com.hockeystreamsgradle.api;

import java.util.List;

/**
 * Created by sean on 3/7/15.
 */
public class GetLiveStreamResponse {
    private String status;
    private String id;
    private String event;
    private String homeTeam;
    private String showScores;
    private String homeScore;
    private String awayTeam;
    private String awayScore;
    private String startTime;
    private String period;
    private String isHd;
    private String feedType;
    private List<Logo> logos;
    private List<StreamInfo> streams;
    private List<StreamInfo> HDstreams;
    private List<StreamInfo> SDstreams;
    private List<StreamInfo> nonDVR;
    private List<StreamInfo> nonDVRSD;
    private List<StreamInfo> nonDVRHD;
    private List<StreamInfo> TrueLiveSD;
    private List<StreamInfo> TrueLiveHD;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getShowScores() {
        return showScores;
    }

    public void setShowScores(String showScores) {
        this.showScores = showScores;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getIsHd() {
        return isHd;
    }

    public void setIsHd(String isHd) {
        this.isHd = isHd;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public List<Logo> getLogos() {
        return logos;
    }

    public void setLogos(List<Logo> logos) {
        this.logos = logos;
    }

    public List<StreamInfo> getStreams() {
        return streams;
    }

    public void setStreams(List<StreamInfo> streams) {
        this.streams = streams;
    }

    public List<StreamInfo> getHDstreams() {
        return HDstreams;
    }

    public void setHDstreams(List<StreamInfo> HDstreams) {
        this.HDstreams = HDstreams;
    }

    public List<StreamInfo> getSDstreams() {
        return SDstreams;
    }

    public void setSDstreams(List<StreamInfo> SDstreams) {
        this.SDstreams = SDstreams;
    }

    public List<StreamInfo> getNonDVR() {
        return nonDVR;
    }

    public void setNonDVR(List<StreamInfo> nonDVR) {
        this.nonDVR = nonDVR;
    }

    public List<StreamInfo> getNonDVRSD() {
        return nonDVRSD;
    }

    public void setNonDVRSD(List<StreamInfo> nonDVRSD) {
        this.nonDVRSD = nonDVRSD;
    }

    public List<StreamInfo> getNonDVRHD() {
        return nonDVRHD;
    }

    public void setNonDVRHD(List<StreamInfo> nonDVRHD) {
        this.nonDVRHD = nonDVRHD;
    }

    public List<StreamInfo> getTrueLiveSD() {
        return TrueLiveSD;
    }

    public void setTrueLiveSD(List<StreamInfo> trueLiveSD) {
        TrueLiveSD = trueLiveSD;
    }

    public List<StreamInfo> getTrueLiveHD() {
        return TrueLiveHD;
    }

    public void setTrueLiveHD(List<StreamInfo> trueLiveHD) {
        TrueLiveHD = trueLiveHD;
    }
}
