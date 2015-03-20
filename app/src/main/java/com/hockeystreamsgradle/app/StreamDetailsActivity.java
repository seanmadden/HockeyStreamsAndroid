package com.hockeystreamsgradle.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.hockeystreamsgradle.api.APIWrapper;
import com.hockeystreamsgradle.api.GetLiveStreamResponse;
import com.hockeystreamsgradle.api.StreamInfo;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Shows the details for a specific Stream
 */
public class StreamDetailsActivity extends Activity{
    private final APIWrapper api = APIWrapper.getInstance();
    private GetLiveStreamResponse liveStreamResponse = null;
    private Context context = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streamdetails);
        context = this;

        //1. Get the stream Id
        final String streamId = getIntent().getStringExtra("streamId");

        //2. Call getLiveStream API
        api.getLiveStream(streamId, new Callback<GetLiveStreamResponse>() {
            @Override
            public void success(GetLiveStreamResponse getLiveStreamResponse, Response response) {
                //liveStreamResponse = getLiveStreamResponse;
                TextView teamsPlaying = (TextView) findViewById(R.id.teamsPlaying);
                teamsPlaying.setText("Stream Details");
                if (getLiveStreamResponse != null) {
                    //teamsPlaying.setText(getLiveStreamResponse.getAwayTeam() + " vs " + getLiveStreamResponse.getHomeTeam());
                    VideoView videoView = (VideoView) findViewById(R.id.liveGameView);
                    teamsPlaying.setText(getLiveStreamResponse.getHDstreams().get(0).getSrc());
                    videoView.setVideoURI(Uri.parse(getLiveStreamResponse.getHDstreams().get(0).getSrc()));
                    videoView.setMediaController(new MediaController(StreamDetailsActivity.this));


                    videoView.requestFocus();
                    videoView.start();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Unable to obtain stream");
                builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog aDialog = builder.create();
                aDialog.show();
            }
        });


    }

}
