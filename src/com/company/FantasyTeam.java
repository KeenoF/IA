package com.company;

import java.util.ArrayList;

public class FantasyTeam {
    private int teamSize;
    private String teamName;
    ArrayList<Player> team;

    //
    public FantasyTeam(String teamName, int teamSize) {
        this.teamName = teamName;
        this.teamSize = teamSize;
        team = new ArrayList<>();
    }

    public void addPlayer(Player p) {
        if (team.size() < teamSize) {
            team.add(p);

        } else {
            System.out.println("There is not enough space in your team team");
            System.out.println(teamSize);

        }

    }




    //
    public int getTeamSize() {
        return teamSize;
    }

    //
    public void displayTeamStats() {
        for (int i = 0; i < team.size(); i++) {
            team.get(i).display();

        }
    }

    //
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

    //
    public Player getPlayer(int PlayerNumber){
        return team.get(PlayerNumber);
    }

    //
    public boolean isFull(){
        return team.size() == 5;
    }

    public boolean isNotFull(){
        return team.size() <5;
    }

    //
    public int playerCount(){
        return team.size();
    }

}
