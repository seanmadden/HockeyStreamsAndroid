package com.hockeystreamsgradle.api;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by sean on 2/22/15.
 */
@Data
public class LiveGame implements Serializable {
    private static final long serialVersionUID = -6828001215155631306L;

    private String id;
    private String event; //Could make an enum, but I think they stream other events (super bowl)
    private String showScores;
    private String homeTeam;
    private String homeScore;
    private String awayTeam;
    private String awayScore;
    private String startTime;
    private String period;
    private String isHd;
    private int isPlaying;
    private int isWMV;
    private int isFlash;
    private int isiStream;
    private String feedType;
    private String srcUrl;
    private String hdUrl;
    private String sdUrl;
    private String TrueLiveSD;
    private String TrueLiveHD;
}
