package com.company;

// Class that creates a basketball player by inheriting from player
public class BasketballPlayer extends Player{
    private double points;
    private double rebounds;
    private double assists;
    private double blocks;
    private double steals;
    private double turnover;
    private double fieldgoalpercentage;
    private double threepointpercentage;
    private double freethrowpercentage;


    public boolean setPoints(double p){
        if (p >= 0){
            points = p;
            return true;
        }
        else{
            System.out.println(" The stat is not a positive number ");
            return false;
        }
    }


    public boolean setRebounds(double r){
        if (r >= 0){
            rebounds = r;
            return true;
        }
        else{
            System.out.println(" The stat is not a positive number ");
            return false;
        }
    }


    public boolean setAssists(double a){
        if (a >= 0){
            assists = a;
            return true;
        }
        else{
            System.out.println(" The stat is not a positive number ");
            return false;
        }
    }


    public boolean setBlocks(double b){
        if (b >= 0){
            blocks = b;
            return true;
        }
        else{
            System.out.println(" The stat is not a positive number ");
            return false;
        }
    }


    public boolean setSteals(double s){
        if (s > 0){
            steals = s;
            return true;
        }
        else{
            System.out.println(" The stat is not a positive number ");
            return false;
        }

    }


    public boolean setTurnover(double t){
        if (t > 0){
            turnover = t;
            return true;
        }
        else{
            System.out.println(" The stat is not a positive number ");
            return false;
        }

    }


    public boolean setFieldgoalpercentage(double fg){
        if (fg > 0){
            fieldgoalpercentage = fg;
            return true;
        }
        else{
            System.out.println(" The stat is not a positive number ");
            return false;
        }

    }


    public boolean setThreepointpercentage(double tp){
        if (threepointpercentage > 0){
            threepointpercentage = tp;
            return true;
        }
        else{
            System.out.println(" The stat is not a positive number ");
            return false;
        }

    }


    public boolean setFreethrowpercentage(double ft){
        if (freethrowpercentage > 0){
            freethrowpercentage = ft;
            return true;
        }
        else{
            System.out.println(" The stat is not a positive number ");
            return false;
        }

    }


    public double getPoints(){
        return points;
    }


    public double getRebounds(){
        return rebounds;
    }


    public double getAssists(){
        return assists;
    }


    public double getBlock(){
        return blocks;
    }


    public double getSteals(){
        return steals;
    }


    public double getTurnover(){
        return turnover;
    }


    public double getFieldgoalpercentage(){
        return fieldgoalpercentage;
    }


    public double getThreepointpercentage(){
        return threepointpercentage;
    }


    public double getFreethrowpercentage(){
        return freethrowpercentage;
    }

    //Constructor for a basketball player which sets all of their statistics
    public BasketballPlayer(String name,String position,double points,double rebounds,double steals,double assists,double blocks,double turnover,
                            double fieldgoalpercentage,double threepointpercentage,double freethrowpercentage, String owner ){
        super(name,position,owner);
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.turnover = turnover;
        this.threepointpercentage = threepointpercentage;
        this.freethrowpercentage = freethrowpercentage;
        this.fieldgoalpercentage = fieldgoalpercentage;


    }

    // Display basketball specific stats
    @Override
    public void display(){
        super.display();
        System.out.println();
        System.out.println(getName() + " has averaged " + getPoints() + " points per game this season");
        System.out.println(getName() + " has averaged " + getRebounds() + " rebounds per game this season");
        System.out.println(getName() + " has averaged " + getBlock() + " blocks per game this season");
        System.out.println(getName() + " has averaged " + getAssists()+ " assists per game this season");
        System.out.println(getName() + " has averaged " + getSteals() + " steals per game this season");
        System.out.println(getName() + " has averaged " + getTurnover()+ " turnover per game this season");
        System.out.println(getName() + " has a 3P% of " + getThreepointpercentage() + "% this season");
        System.out.println(getName() + " has a FT% of " + getFreethrowpercentage() + "% this season");
        System.out.println(getName() + " has a FG% of " + getFieldgoalpercentage() + "% this season");
        System.out.println(getName() + " is owned by " + getOwner());
    }

    //Clones all of the fields from one player to another
    public void copy(BasketballPlayer p){
        super.copy(p);
        this.assists = p.assists;
        this.steals = p.steals;
        this.turnover = p.turnover;
        this.fieldgoalpercentage = p.fieldgoalpercentage;
        this.threepointpercentage = p.threepointpercentage;
        this.rebounds = p.rebounds;
        this.freethrowpercentage = p.freethrowpercentage;
        this.points = p.points;
        this.blocks = p.blocks;
    }

    //Constructor that splits data from a text file and then assigns each split data to certain stat creating a separate list in the process
    public BasketballPlayer(String dataFromFile){
        super();
        String[] rawFields = dataFromFile.split(",");
        if (rawFields.length <= 14 ){
            name = rawFields[0];
            position = rawFields[1];
            points = Double.parseDouble(rawFields[2]);
            fieldgoalpercentage = Double.parseDouble(rawFields[3]);
            threepointpercentage = Double.parseDouble(rawFields[4]);
            freethrowpercentage = Double.parseDouble(rawFields[5]);
            rebounds = Double.parseDouble(rawFields[6]);
            assists = Double.parseDouble(rawFields[7]);
            steals = Double.parseDouble(rawFields[8]);
            blocks = Double.parseDouble(rawFields[9]);
            turnover = Double.parseDouble(rawFields[10]);
            owner = rawFields[11];
        }
    }

}
