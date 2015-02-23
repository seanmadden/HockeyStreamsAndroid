package com.hockeystreamsgradle.api;

/**
 * Created by sean on 2/22/15.
 */
public class LoginResponse {
    String status;
    String uid;
    String username;
    String favteam;
    String membership;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getFavteam() {
        return favteam;
    }

    public void setFavteam(String favteam) {
        this.favteam = favteam;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String token;
}
