package com.hockeystreamsgradle.api;

import lombok.Data;

/**
 * Created by sean on 2/22/15.
 */
@Data
public class LoginBody {
    private String username;
    private String password;
    private String key;
}
