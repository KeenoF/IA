package com.company;

// Class that creates a generic player for any sport
public class Player {
    protected String name;
    protected String position;
    protected String owner;

    // Setter that sets the players position
    public boolean setPosition(String pos){
        position = pos;
        return true;
    }

    // Setter that sets the players owner
    public boolean setOwner(String o){
        owner = o;
        return true;
    }
    // Getter that returns players position
    public String getPos(){
        return position;
    }

    // Getter that returns players name
    public String getName() {
        return name;
    }

    // Getter that returns players owner
    public String getOwner() {
        return owner;
    }

    // Constructor that creates a player for any sport
    public Player(String name, String position, String owner) {
        this.name = name;
        this.position = position;
        this.owner = owner;
    }

    // Blank constructor used by subclasses
    public Player(){
    }

    // Blank constructor used by subclasses
    public void display(){
    }


    public void copy(Player p){
        this.position = p.position;
    }

}
