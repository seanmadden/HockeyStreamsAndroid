package com.hockeystreamsgradle.api;

import java.util.List;

import lombok.Data;

/**
 * Created by sean on 3/7/15.
 */
@Data
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
}
