package com.hockeystreamsgradle.api;

import org.json.JSONObject;
import retrofit.Callback;
import retrofit.http.*;

/**
 * Created by sean on 2/22/15.
 */
public interface HockeyStreamsAPI {
    @FormUrlEncoded
    @POST("/Login")
    void login(@Field("username") String username,
               @Field("password") String password,
               @Field("key") String key,
               Callback<LoginResponse> callback);

    @GET("/GetLive")
    void getLive(@Query("token") String token);

}
