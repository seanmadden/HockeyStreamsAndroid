package com.hockeystreamsgradle.api;

import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by sean on 2/22/15.
 */
@Data
public class GetLiveResponse {
    private String status;
    private List<LiveGame> schedule;
}
