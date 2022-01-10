package com.company;

import java.util.ArrayList;

public class FantasyBasketballTeam extends FantasyTeam {
    public FantasyBasketballTeam(String teamName){
        super(teamName,5);
    }

    public void overallScore() {
        int overallscore = 0;
        ArrayList<String> overallPlayers;
        overallPlayers = FileHandling.readFileData("team.txt");
        for (int i = 0; i < overallPlayers.size(); i++) {
            String playerData = overallPlayers.get(i);
            BasketballPlayer c = new BasketballPlayer(playerData);
            if (c.getPoints() <= 10) {
                overallscore = overallscore + 1;
            } else if (c.getPoints() > 10 && c.getPoints() <= 20) {
                overallscore = overallscore + 3;
            } else if (c.getPoints() > 20 && c.getPoints() <= 30) {
                overallscore = overallscore + 5;
            } else if (c.getPoints() < 40) {
                overallscore = overallscore + 10;
            }
            if (c.getAssists() <= 5) {
                overallscore = overallscore + 1;
            } else if (c.getAssists() > 5 && c.getAssists() <= 10) {
                overallscore = overallscore + 3;
            } else if (c.getAssists() > 10 && c.getAssists() <= 15) {
                overallscore = overallscore + 5;
            } else if (c.getAssists() < 15) {
                overallscore = overallscore + 10;
            }
            if (c.getRebounds() <= 3) {
                overallscore = overallscore + 1;
            } else if (c.getRebounds() > 3 && c.getRebounds() <= 7) {
                overallscore = overallscore + 3;
            } else if (c.getRebounds() > 7 && c.getRebounds() <= 10) {
                overallscore = overallscore + 5;
            } else if (c.getRebounds() < 10) {
                overallscore = overallscore + 10;
            }
            if (c.getBlock() <= 3) {
                overallscore = overallscore + 1;
            } else if (c.getBlock() > 3 && c.getBlock() <= 6) {
                overallscore = overallscore + 3;
            } else if (c.getBlock() > 6 && c.getBlock() <= 9) {
                overallscore = overallscore + 5;
            } else if (c.getBlock() < 9) {
                overallscore = overallscore + 10;
            }
            if (c.getSteals() <= 3) {
                overallscore = overallscore + 1;
            } else if (c.getSteals() > 3 && c.getSteals() <= 6) {
                overallscore = overallscore + 3;
            } else if (c.getSteals() > 6 && c.getSteals() <= 9) {
                overallscore = overallscore + 5;
            } else if (c.getSteals() < 9) {
                overallscore = overallscore + 10;
            }
            if (c.getTurnover() == 0) {
                overallscore = overallscore + 0;
            } else if (c.getTurnover() >= 1 && c.getTurnover() <= 4) {
                overallscore = overallscore - 2;
            } else if (c.getTurnover() > 4 && c.getTurnover() <= 9) {
                overallscore = overallscore - 5;
            } else if (c.getTurnover() < 9) {
                overallscore = overallscore - 10;
            }
            if (c.getThreepointpercentage() <= 20) {
                overallscore = overallscore + 1;
            } else if (c.getThreepointpercentage() > 20 && c.getThreepointpercentage() <= 40) {
                overallscore = overallscore + 2;
            } else if (c.getThreepointpercentage() > 40 && c.getThreepointpercentage() <= 60) {
                overallscore = overallscore + 5;
            } else if (c.getThreepointpercentage() < 60) {
                overallscore = overallscore + 10;
            }
            if (c.getThreepointpercentage() <= 20) {
                overallscore = overallscore + 1;
            } else if (c.getThreepointpercentage() > 20 && c.getThreepointpercentage() <= 40) {
                overallscore = overallscore + 2;
            } else if (c.getThreepointpercentage() > 40 && c.getThreepointpercentage() <= 60) {
                overallscore = overallscore + 5;
            } else if (c.getThreepointpercentage() < 60) {
                overallscore = overallscore + 10;
            }
            System.out.println(c.getName() + " has a overall score of " + overallscore);

        }
    }

    public void addPlayer(BasketballPlayer p){
        super.addPlayer(p);
    }

    public void displayTeam(){
        super.displayTeam();
    }

    public void displayTeamStats(){
        super.displayTeamStats();
    }

    public BasketballPlayer getPlayer(int playerNumber){
        return (BasketballPlayer) super.getPlayer(playerNumber);

    }
}
