package com.hockeystreamsgradle.utils;

import com.hockeystreamsgradle.api.GetLiveStreamResponse;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created by rlaks939 on 15-03-14.
 */
public class GameUtils {
    private GameUtils() {};

    @Getter
    @RequiredArgsConstructor
    public enum State {
        YES(1),
        NO(0);

        private final int state;
    }

    public String getSdUrl(GetLiveStreamResponse getLiveStreamResponse) {
        return "sdUrl";
    }
}
