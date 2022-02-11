package com.company;

public class Main {

    public static void main(String[] args) {
        FantasyLeague testFantasyLeague = new FantasyLeague("players.txt");
        LeagueGUI myGUI = new LeagueGUI(testFantasyLeague);
        LoginGUI myLogin = new LoginGUI(myGUI,"users.txt");
    }
}
