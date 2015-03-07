package com.hockeystreamsgradle.api;

import android.util.Log;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Used to call the hockeystreams API. Wraps up token and endpoint.
 */
public class APIWrapper {
    private static APIWrapper instance = null;

    private HockeyStreamsAPI api;
    private String token;
    private final String HOCKEY_STREAMS_ENDPOINT = "https://api.hockeystreams.com";

    protected APIWrapper() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(HOCKEY_STREAMS_ENDPOINT)
                .build();

        api = restAdapter.create(HockeyStreamsAPI.class);

        //Attempt to get the token from shared preferences

    }

    /**
     * Gets a singleton APIWrapper
     * @return the instance of the wrapper
     */
    public static APIWrapper getInstance() {
        if (instance == null) {
            instance = new APIWrapper();
        }

        return instance;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public void login(final String username, final String password, final Callback<LoginResponse> callback) {
        try {
            api.login(username, password, Constants.API_KEY, new Callback<LoginResponse>() {
                @Override
                public void success(LoginResponse loginResponse, Response response) {
                    if (loginResponse.getStatus().equals("Success")) {
                        token = loginResponse.getToken();
                        callback.success(loginResponse, response);
                    }
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

    public void getLive(final Callback<GetLiveResponse> callback) {
        if (token == null) return;

        try {
            api.getLive(token, callback);
        } catch (Exception e) {
            Log.e(Constants.TAG, e.getMessage(), e);
        }
    }

    public void getLiveStream(String id, final Callback<GetLiveStreamResponse> callback) {
        if (token == null) return;

        try {
            api.getLiveStream(token, id, callback);
        } catch (Exception e) {
            Log.e(Constants.TAG, e.getMessage(), e);
        }
    }
}
