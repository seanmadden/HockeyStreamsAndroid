package com.hockeystreamsgradle.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.hockeystreamsgradle.api.LiveGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sean on 2/24/15.
 */
public class ChooseLiveGameActivity extends Activity {
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.chooselivegame);

        final List<LiveGame> schedule = (List<LiveGame>)getIntent().getSerializableExtra("schedule");
        final List<String> liveGameList = new ArrayList<String>();

        //1. Add the games to the games list
        for (final LiveGame game : schedule) {
            liveGameList.add(game.getAwayTeam() + " vs " + game.getHomeTeam());
        }

        //2. Show the games in the List View
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                liveGameList.toArray(new String[liveGameList.size()]));

        final ListView gameListView = (ListView) findViewById(R.id.liveGameList);
        gameListView.setAdapter(adapter);

        //3. Set the onclick handler
        gameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //1. Get the gameInfo from the original schedule
                final LiveGame gameInfo = schedule.get(i);

                //2. Build the intent
                final Intent streamDetailsIntent = new Intent(context, StreamDetailsActivity.class);
                streamDetailsIntent.putExtra("streamId", gameInfo.getId());

                //3. Start the activity
                startActivity(streamDetailsIntent);
            }
        });
    }
}
