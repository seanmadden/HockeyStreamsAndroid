package com.hockeystreamsgradle.utils;

import static com.hockeystreamsgradle.utils.GameUtils.State;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMap;
import com.hockeystreamsgradle.api.LiveGame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * Builds predicates to be used for filtering a GameList
 *
 * conditions: enum
 */
@Getter
@Setter
public class FilterPredicateFactory {
    public enum Condition {
        NHL,
        LIVE,
        LIVE_NHL,
        ALL;
    }

    private Map<Condition,Predicate<LiveGame>> conditionPredicateMap =
            new ImmutableMap.Builder<Condition,Predicate<LiveGame>>()
                .put(Condition.ALL,new Predicate<LiveGame>() {
                    @Override
                    public boolean apply(LiveGame liveGame) {
                        return true;
                    }
                })
                .put(Condition.NHL, new Predicate<LiveGame>(){
                    @Override
                    public boolean apply(LiveGame liveGame) {
                        return liveGame.getEvent().toLowerCase().equals("nhl");
                    }
                })
                .put(Condition.LIVE_NHL, new Predicate<LiveGame>() {
                    @Override
                    public boolean apply(LiveGame liveGame) {
                        boolean isPlaying = (liveGame.getIsPlaying() == State.YES.getState()) ? true : false;
                        return isPlaying && liveGame.getEvent().toLowerCase().equals("nhl");
                    }
                })
                .put(Condition.LIVE, new Predicate<LiveGame>() {
                    @Override
                    public boolean apply(LiveGame liveGame) {
                        return (liveGame.getIsPlaying() == State.YES.getState()) ? true : false;
                    }
                }).build();


    public FilterPredicateFactory() {}

    public Predicate<LiveGame> getPredicate(Condition condition) throws RuntimeException {
        Predicate<LiveGame> liveGamePredicate = conditionPredicateMap.get(condition);
        /*if (liveGamePredicate == null) {
            throw new RuntimeException("Condition does not exist");
        }*/

        return liveGamePredicate;
    }
}
