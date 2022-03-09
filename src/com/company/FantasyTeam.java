package com.company;

import java.util.ArrayList;

// Class that creates a generic team format that can used by any sport
public class FantasyTeam {
    private int teamSize;
    private String teamName;
    ArrayList<Player> team;

    // Contructor that creates the fantasy team
    public FantasyTeam(String teamName, int teamSize) {
        this.teamName = teamName;
        this.teamSize = teamSize;
        team = new ArrayList<>();
    }

    // Adds a player to the team
    public void addPlayer(Player p) {
        if (team.size() < teamSize) {
            team.add(p);

        } else {
            System.out.println("There is not enough space in your team team");
            System.out.println(teamSize);

        }

    }

    // Getter returns team size
    public int getTeamSize() {
        return teamSize;
    }

    public void displayTeamStats() {
        for (int i = 0; i < team.size(); i++) {
            team.get(i).display();

        }
    }

    public void displayTeam() {
        for (int i = 0; i < team.size(); i++) {
            System.out.print(team.get(i).getName() + " ");
        }
        System.out.println();
    }

    //
    public void removePlayer(Player p) {
        boolean found = false;
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getName().equals(p.getName())) {
                team.remove(i);
                found = true;

            }

        }
        if (found == false) {
            System.out.println(" Player " + p.getName() + " not found in team " + teamName);
        }

    }

    // Getter that returns a player in the file
    public Player getPlayer(int PlayerNumber){
        return team.get(PlayerNumber);
    }

    // Checks if the team is full
    public boolean isFull(){
        return team.size() == 5;
    }

    // Checks if the team is not full
    public boolean isNotFull(){
        return team.size() <5;
    }


    public int playerCount(){
        return team.size();
    }

}
