package com.company;

import javax.crypto.AEADBadTagException;
import java.util.ArrayList;
import java.util.Scanner;

//Contains all the players available for selection for a team
public class FantasyLeague {
    ArrayList<BasketballPlayer> players;

    //Constructs
    public FantasyLeague(String dataFile) {
        players = new ArrayList<>();
        readPlayers(dataFile);
    }

    //Read player method to read in players from a file
    public void readPlayers(String fileName) {
        ArrayList<String> allPlayers;
        allPlayers = FileHandling.readFileData(fileName);
        for (int i = 0; i < allPlayers.size(); i++) {
            String playerData = allPlayers.get(i);
            BasketballPlayer p = new BasketballPlayer(playerData);
            players.add(p);
        }
    }
    //Reads in a new text file with updated stats and updates players with their new stats
    public void updatePlayers(){
        ArrayList<String> updatePlayers;
        updatePlayers = FileHandling.readFileData("update.txt");
        for (int i = 0; i < updatePlayers.size(); i++) {
            String playerData = updatePlayers.get(i);
            BasketballPlayer p = new BasketballPlayer(playerData);
            for(BasketballPlayer existing: players){
                boolean success = true;
                if (p.getName().equals(existing.getName())){
                    success = success && existing.setPosition(p.getPos());
                    success = success && existing.setPoints(p.getPoints());
                    success = success && existing.setAssists(p.getAssists());
                    success = success && existing.setBlocks(p.getBlock());
                    success = success && existing.setFieldgoalpercentage(p.getFieldgoalpercentage());
                    success = success && existing.setFreethrowpercentage(p.getFreethrowpercentage());
                    success = success && existing.setThreepointpercentage(p.getThreepointpercentage());
                    success = success && existing.setRebounds(p.getRebounds());
                    success = success && existing.setSteals(p.getSteals());
                    success = success && existing.setTurnover(p.getTurnover());
                    success = success && existing.setOwner(p.getOwner());
                    if (success == true ){
                        existing.copy(p);
                    }
                }
            }
        }
    }

    public void displayAll() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println(i + 1);
            players.get(i).display();
        }
    }

    //Getter for when a user enters a number that corresponds with a certain player that can choose that player to select
    public BasketballPlayer getPlayer(int playerNumber) {
        if (playerNumber < players.size() && playerNumber >= 0) {
            return players.get(playerNumber);
        } else {
            System.out.println("Invalid player number");
            System.out.println(playerNumber);
            return null;
        }
    }

    public BasketballPlayer choosePlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number corresponding to number associated to a player");
        int a = sc.nextInt();
        return players.get(a);
    }

    public FantasyBasketballTeam buildTeam(){
        FantasyBasketballTeam newTeam = new FantasyBasketballTeam("dummy");
        for( int i = 0; i<5; i++){
            BasketballPlayer newplayer = choosePlayer();
            newTeam.addPlayer(newplayer);
        }
        return newTeam;
    }

}
