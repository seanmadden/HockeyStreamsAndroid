package com.hockeystreamsgradle.app;

import static com.hockeystreamsgradle.utils.FilterPredicateFactory.Condition;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.hockeystreamsgradle.api.Constants;
import com.hockeystreamsgradle.api.LiveGame;
import com.hockeystreamsgradle.utils.FilterPredicateFactory;
import com.hockeystreamsgradle.utils.GameListAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Filter;

/**
 * Created by sean on 2/24/15.
 */
public class ChooseLiveGameActivity extends Activity {
    FilterPredicateFactory filterPredicateFactory = new FilterPredicateFactory();
    private static final int NUM_COLUMNS = 6;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.chooselivegame);

        final List<LiveGame> scheduleUnfiltered = (List<LiveGame>)getIntent().getSerializableExtra("schedule");
        List<LiveGame> scheduleFiltered = filterSchedule(scheduleUnfiltered, Condition.LIVE_NHL);
        final List<String> liveGameList = new ArrayList<String>();

        if (scheduleFiltered.size() == 0) {
            // View as if Condition.ALL is set
            scheduleFiltered = filterSchedule(scheduleUnfiltered, Condition.NHL);
        }

        GridView gameListView = (GridView) findViewById(R.id.liveGameList);

        //2. Show the games in the List View
        final GameListAdapter gameListAdapter = new GameListAdapter(this, gameListView.getId(), scheduleFiltered);
        final int rows = (int) Math.ceil(liveGameList.size()/NUM_COLUMNS);
        gameListView.setNumColumns(NUM_COLUMNS);
        gameListView.setAdapter(gameListAdapter);

        //3. Set the onclick handler
        gameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.performClick();
            }
        });
    }

    private List<LiveGame> filterSchedule(List<LiveGame> liveGames, Condition condition) {
        Collection<LiveGame> filteredCollection =
                Collections2.filter(liveGames, filterPredicateFactory.getPredicate(condition));
        return Lists.newArrayList(filteredCollection.iterator());
    }
}
