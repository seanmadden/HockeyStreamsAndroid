package com.hockeystreamsgradle.api;

import lombok.Data;

/**
 * Created by sean on 2/22/15.
 */
@Data
public class LoginResponse {
    private String status;
    private String uid;
    private String username;
    private String favteam;
    private String membership;
    private String token;
}
