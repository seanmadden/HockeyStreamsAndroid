package com.hockeystreamsgradle.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.hockeystreamsgradle.api.APIWrapper;
import com.hockeystreamsgradle.api.GetLiveStreamResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Shows the details for a specific Stream
 */
public class StreamDetailsActivity extends Activity{
    private final APIWrapper apiWrapper = APIWrapper.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streamdetails);

        //1. Get the stream Id
        final String streamId = getIntent().getStringExtra("streamId");

        //2. Call getLiveStream API
        apiWrapper.getLiveStream(streamId, new Callback<GetLiveStreamResponse>() {
            @Override
            public void success(GetLiveStreamResponse getLiveStreamResponse, Response response) {
                TextView teamsPlaying = (TextView) findViewById(R.id.teamsPlaying);
                teamsPlaying.setText(getLiveStreamResponse.getAwayTeam() + " vs " + getLiveStreamResponse.getHomeTeam());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

}
