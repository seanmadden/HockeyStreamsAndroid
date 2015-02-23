package com.hockeystreamsgradle.api;

/**
 * Created by sean on 2/22/15.
 */
public class LiveGame {
    String id;
    String event; //Could make an enum, but I think they stream other events (super bowl)
    String showScores;
    String homeTeam;
    String homeScore;
    String awayTeam;
    String awayScore;
    String startTime;
    String period;
    String isHd;
    int isPlaying;
    int isWMV;
    int isFlash;
    int isiStream;
    String feedType;
    String srcUrl;
    String hdUrl;
    String sdUrl;
    String TrueLiveSD;
    String TrueLiveHD;

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

    public String getShowScores() {
        return showScores;
    }

    public void setShowScores(String showScores) {
        this.showScores = showScores;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
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

    public int getIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(int isPlaying) {
        this.isPlaying = isPlaying;
    }

    public int getIsWMV() {
        return isWMV;
    }

    public void setIsWMV(int isWMV) {
        this.isWMV = isWMV;
    }

    public int getIsFlash() {
        return isFlash;
    }

    public void setIsFlash(int isFlash) {
        this.isFlash = isFlash;
    }

    public int getIsiStream() {
        return isiStream;
    }

    public void setIsiStream(int isiStream) {
        this.isiStream = isiStream;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }

    public String getHdUrl() {
        return hdUrl;
    }

    public void setHdUrl(String hdUrl) {
        this.hdUrl = hdUrl;
    }

    public String getSdUrl() {
        return sdUrl;
    }

    public void setSdUrl(String sdUrl) {
        this.sdUrl = sdUrl;
    }

    public String getTrueLiveSD() {
        return TrueLiveSD;
    }

    public void setTrueLiveSD(String trueLiveSD) {
        TrueLiveSD = trueLiveSD;
    }

    public String getTrueLiveHD() {
        return TrueLiveHD;
    }

    public void setTrueLiveHD(String trueLiveHD) {
        TrueLiveHD = trueLiveHD;
    }
}
