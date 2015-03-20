package com.hockeystreamsgradle.api;

import lombok.Getter;

/**
 * Created by sean on 2/24/15.
 */
public final class Constants {
    private Constants() {}

    public static final String TAG = "HS";
    public static final String API_KEY = "17601b27272c619c8c1a0469794c5bf3";

    @Getter
    public static enum Nhl_Team {
        ANA("Anaheim", "Ducks"),
        ARI("Arizona", "Coyotes"),
        BOS("Boston", "Bruins"),
        BUF("Buffalo", "Sabers"),
        CGY("Calgary", "Flames"),
        CAR("Carolina", "Hurricanes"),
        CHI("Chicago", "Blackhawks"),
        COL("Colorado", "Avalanche"),
        CBJ("Columbus", "Blue Jackets"),
        DAL("Dallas","Stars"),
        DET("Detroit","Red Wings"),
        EDM("Edmonton","Oilers"),
        FLA("Florida","Panthers"),
        LA("Los Angeles", "Kings"),
        MIN("Minnesota", "Wild"),
        MTL("Montreal","Canadiens"),
        NSH("Nashville", "Predators"),
        NJ("New Jersey", "Devils"),
        NYI("New York", "Islanders"),
        NYR("New York", "Rangers"),
        OTT("Ottawa", "Senators"),
        PHI("Philadelphia", "Flyers"),
        PIT("Pittsburgh","Penguins"),
        SJ("San Jose", "Sharks"),
        STL("St Louis", "Blues"),
        TB("Tampa Bay", "Lightning"),
        TOR("Toronto", "Maple Leafs"),
        VAN("Vancouver", "Canucks"),
        WAS("Washington", "Capitals"),
        WIN("Winnipeg", "Jets");


        final private String teamName;
        final private String shortName;
        final private String cityName;
        final private String fullName;

        private Nhl_Team(String cityName, String teamName) {
            this.teamName = teamName;
            this.shortName = this.name();
            this.cityName = cityName;
            this.fullName = String.format("%s %s", this.cityName, this.teamName);
        }

        public static Nhl_Team getTeam(String team) {
            for (Nhl_Team nhlTeam : values()) {
                if (nhlTeam.getFullName().toLowerCase().equals(team.toLowerCase())) {
                    return nhlTeam;
                }
            }
            return null;
        }
    }
}
