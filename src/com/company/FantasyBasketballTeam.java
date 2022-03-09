package com.company;


public class FantasyBasketballTeam extends FantasyTeam {
    public FantasyBasketballTeam(String teamName){
        super(teamName,5);
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
