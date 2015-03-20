package com.hockeystreamsgradle.utils;

import static com.hockeystreamsgradle.api.Constants.Nhl_Team;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hockeystreamsgradle.api.Constants;
import com.hockeystreamsgradle.api.LiveGame;
import com.hockeystreamsgradle.app.R;
import com.hockeystreamsgradle.app.StreamDetailsActivity;

import java.util.List;

/**
 * Created by rlaks939 on 15-03-18.
 */
public class GameListAdapter extends ArrayAdapter<LiveGame> {
    Context context;
    List<LiveGame> liveGames;

    public GameListAdapter(Context context, int a, List<LiveGame> liveGames) {
        super(context, a, liveGames);
        this.liveGames = liveGames;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parentView) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v;
        if (convertView == null) {
            v = inflater.inflate(R.layout.game_card, null);
        } else {
            v = convertView;
        }
        TextView homeTeam = (TextView) v.findViewById(R.id.homeTeam);
        TextView homeScore = (TextView) v.findViewById(R.id.homeScore);
        TextView awayTeam = (TextView) v.findViewById(R.id.awayTeam);
        TextView awayScore = (TextView) v.findViewById(R.id.awayScore);

        if (liveGames.get(position) != null) {
            final LiveGame game = liveGames.get(position);
            homeTeam.setText(Nhl_Team.getTeam(game.getHomeTeam()).getShortName());
            homeScore.setText(game.getHomeScore());
            awayTeam.setText(Nhl_Team.getTeam(game.getAwayTeam()).getShortName());
            awayScore.setText(game.getAwayScore());

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //2. Build the intent
                    final Intent streamDetailsIntent = new Intent(context, StreamDetailsActivity.class);
                    streamDetailsIntent.putExtra("streamId", game.getId());

                    //3. Start the activity
                    context.startActivity(streamDetailsIntent);
                }
            });
        }

        return v;
    }
}
