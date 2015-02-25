package com.hockeystreamsgradle.app;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by sean on 2/24/15.
 */
public class WatchGameActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watchgame);

        //1. Get the URL
        final String url = getIntent().getStringExtra("streamUrl");

        //2. Start the video
        final VideoView videoView = (VideoView) findViewById(R.id.gameView);
        videoView.setVideoURI(Uri.parse(url));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
    }
}
