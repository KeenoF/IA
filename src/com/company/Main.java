package com.company;

public class Main {

    public static void main(String[] args) {
        FantasyLeague testFantasyLeague = new FantasyLeague("players.txt");
        LeagueGUI myGUI = new LeagueGUI(testFantasyLeague);
        LoginGUI myLogin = new LoginGUI(myGUI,"users.txt");

        //TODO Calculate for team overall based on stats of the current players
        //TODO Create graphs
    }
}
