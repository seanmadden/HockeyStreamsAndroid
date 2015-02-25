package com.hockeystreamsgradle.api;

import android.util.Log;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sean on 2/24/15.
 */
public class APIWrapper {

    private HockeyStreamsAPI api;
    private String token;
    private boolean loggedIn;
    private final String HOCKEY_STREAMS_ENDPOINT = "https://api.hockeystreams.com";

    public APIWrapper() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(HOCKEY_STREAMS_ENDPOINT)
                .build();

        api = restAdapter.create(HockeyStreamsAPI.class);
    }

    public void login(final String username, final String password, final Callback<LoginResponse> callback) {
        try {
            api.login(username, password, Constants.API_KEY, new Callback<LoginResponse>() {
                @Override
                public void success(LoginResponse loginResponse, Response response) {
                    token = loginResponse.getToken();
                    loggedIn = loginResponse.getStatus().equals("Success");
                    callback.success(loginResponse, response);
                }

                @Override
                public void failure(RetrofitError error) {
                    callback.failure(error);
                }
            });
        } catch (Exception e) {
            Log.i(Constants.TAG, "ERROR: ", e);
        }
    }

    public void getLiveStreams(final Callback<GetLiveResponse> callback) {
        if (!loggedIn) return;

        try {
            api.getLive(token, callback);
        } catch (Exception e) {
            Log.e(Constants.TAG, e.getMessage(), e);
        }
    }
}