package com.company;

import java.util.ArrayList;

//Contains all the players available for selection for a team
public class FantasyLeague {
    ArrayList<BasketballPlayer> players;


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

    private ArrayList<String> convertToText() {
        BasketballPlayer tempPlayer;
        ArrayList<String> text = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            tempPlayer = players.get(i);
            text.add(tempPlayer.getName() + ",");
            text.add(tempPlayer.getPos() + ",");
            text.add(Double.toString(tempPlayer.getPoints()) + ",");
            text.add(Double.toString(tempPlayer.getRebounds()) + ",");
            text.add(Double.toString(tempPlayer.getAssists()) + ",");
            text.add(Double.toString(tempPlayer.getBlock()) + ",");
            text.add(Double.toString(tempPlayer.getSteals()) + ",");
            text.add(Double.toString(tempPlayer.getTurnover()) + ",");
            text.add(Double.toString(tempPlayer.getFieldgoalpercentage()) + ",");
            text.add(Double.toString(tempPlayer.getThreepointpercentage()) + ",");
            text.add(Double.toString(tempPlayer.getFreethrowpercentage()) + ",");
            text.add(tempPlayer.getOwner() + ",");
            text.add("\n");
        }
        return text;
    }

    public void writePlayers(String filename){
        FileHandling.writeToFile(filename,convertToText(),false);

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

    public void setPlayerOwner(String owner, Player player){
        player.setOwner(owner);
    }

    public int size(){
        return players.size();
    }


}
