package com.hockeystreamsgradle.app;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.hockeystreamsgradle.api.LiveGame;


/**
 * Created by rlaks939 on 15-03-18.
 */
public class GameCard {
    private View view;

    public GameCard(LayoutInflater inflater, TableRow row, LiveGame liveGame) {
        this.view = inflater.inflate(R.layout.game_card, row, false);
        FrameLayout frameLayout = (FrameLayout) view;
        TextView homeTeam = (TextView) frameLayout.getChildAt(0);
        homeTeam.setText(liveGame.getHomeTeam());
    }

}
