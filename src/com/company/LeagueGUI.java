package com.company;

import java.awt.event.*;
import javax.swing.*;

public class LeagueGUI implements ActionListener {
    private int currentPlayerNumber;
    private FantasyLeague testFantasy;
    private FantasyBasketballTeam currentTeam;


    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 600;
    private final int LEFT_MARGIN = 100;
    private final int TOP_MARGIN = 20;
    private final int BUTTON_Y = 400;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 40;
    private final int TEXT_WIDTH = 200;
    private final int TEXT_HEIGHT = 30;
    private String user;

    private JFrame frame;
    private TeamGUI teamForm;
    private JLabel nameLabel;
    private JLabel positionLabel;
    private JLabel pointLabel;
    private JLabel reboundLabel;
    private JLabel blockLabel;
    private JLabel assistLabel;
    private JLabel stealLabel;
    private JLabel turnoverLabel;
    private JLabel ownerLabel;
    private JLabel threepointLabel;
    private JLabel freethrowLabel;
    private JLabel fieldgoalLabel;
    private JButton previousButton;
    private JButton nextButton;
    private JButton teamButton;
    private JButton chooseButton;

    public LeagueGUI(FantasyLeague fantasyLeague){
        this.testFantasy = fantasyLeague;
        this.user = "None";
        currentPlayerNumber = 0;

        frame = new JFrame("League");

        //Field Labels
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(LEFT_MARGIN, TOP_MARGIN,TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(nameLabel);

        positionLabel = new JLabel("Position:");
        positionLabel.setBounds(LEFT_MARGIN, TOP_MARGIN+TEXT_HEIGHT,TEXT_WIDTH,TEXT_HEIGHT);
        frame.add(positionLabel);

        pointLabel = new JLabel("Points:");
        pointLabel.setBounds(LEFT_MARGIN, TOP_MARGIN+TEXT_HEIGHT*2,TEXT_WIDTH,TEXT_HEIGHT);
        frame.add(pointLabel);

        reboundLabel = new JLabel("Rebounds:");
        reboundLabel.setBounds(LEFT_MARGIN, TOP_MARGIN+TEXT_HEIGHT*3,TEXT_WIDTH,TEXT_HEIGHT);
        frame.add(reboundLabel);

        blockLabel = new JLabel("Blocks:");
        blockLabel.setBounds(LEFT_MARGIN, TOP_MARGIN+TEXT_HEIGHT*4,TEXT_WIDTH,TEXT_HEIGHT);
        frame.add(blockLabel);

        assistLabel = new JLabel("Assists:");
        assistLabel.setBounds(LEFT_MARGIN, TOP_MARGIN+TEXT_HEIGHT*5,TEXT_WIDTH,TEXT_HEIGHT);
        frame.add(assistLabel);

        stealLabel = new JLabel("Steals:");
        stealLabel.setBounds(LEFT_MARGIN, TOP_MARGIN+TEXT_HEIGHT*6,TEXT_WIDTH,TEXT_HEIGHT);
        frame.add(stealLabel);

        turnoverLabel = new JLabel("Turnovers:");
        turnoverLabel.setBounds(LEFT_MARGIN, TOP_MARGIN+TEXT_HEIGHT*7,TEXT_WIDTH,TEXT_HEIGHT);
        frame.add(turnoverLabel);

        threepointLabel = new JLabel("3P%:");
        threepointLabel.setBounds(LEFT_MARGIN, TOP_MARGIN+TEXT_HEIGHT*8,TEXT_WIDTH,TEXT_HEIGHT);
        frame.add(threepointLabel);

        freethrowLabel = new JLabel("FT%:");
        freethrowLabel.setBounds(LEFT_MARGIN, TOP_MARGIN+TEXT_HEIGHT*9,TEXT_WIDTH,TEXT_HEIGHT);
        frame.add(freethrowLabel);

        fieldgoalLabel = new JLabel("FG%:");
        fieldgoalLabel.setBounds(LEFT_MARGIN, TOP_MARGIN+TEXT_HEIGHT*10,TEXT_WIDTH,TEXT_HEIGHT);
        frame.add(fieldgoalLabel);

        ownerLabel = new JLabel("Owner:");
        ownerLabel.setBounds(LEFT_MARGIN, TOP_MARGIN+TEXT_HEIGHT*11,TEXT_WIDTH,TEXT_HEIGHT);
        frame.add(ownerLabel);


        //Previous Button which clicks backwards through the data file of players
        previousButton = new JButton("<");
        previousButton.setBounds(LEFT_MARGIN, BUTTON_Y,BUTTON_WIDTH,BUTTON_HEIGHT);
        previousButton.addActionListener(this);
        previousButton.setEnabled(false);
        frame.add(previousButton);

        //Next Button which clicks forward through the data file of players
        nextButton = new JButton(">");
        nextButton.setBounds(LEFT_MARGIN + BUTTON_WIDTH, BUTTON_Y, BUTTON_WIDTH,BUTTON_HEIGHT);
        nextButton.addActionListener(this);
        nextButton.setEnabled(true);
        frame.add(nextButton);

        //Team Button which sends you to the screen that shows your current team
        teamButton = new JButton("Team");
        teamButton.setBounds(LEFT_MARGIN, BUTTON_Y + BUTTON_HEIGHT,BUTTON_WIDTH,BUTTON_HEIGHT);
        teamButton.addActionListener(this);
        teamButton.setEnabled(true);
        frame.add(teamButton);

        //Choose Button which allows you to add the player that is currently being shown on the screen to be added to your team
        chooseButton = new JButton("Choose");
        chooseButton.setBounds(LEFT_MARGIN + BUTTON_WIDTH, BUTTON_Y + BUTTON_HEIGHT,BUTTON_WIDTH,BUTTON_HEIGHT);
        chooseButton.addActionListener(this);
        chooseButton.setEnabled(true);
        frame.add(chooseButton);

        //
        displayPlayerDetails(currentPlayerNumber);

        //
        checkAvailability();

        //Other frame attributes
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(false);

        //create the edit form but it is invisible for now
        teamForm = new TeamGUI(this.testFantasy,this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == ">"){
            currentPlayerNumber++;
            displayPlayerDetails(currentPlayerNumber);
            previousButton.setEnabled(true);
            if(currentPlayerNumber == 99){
                nextButton.setEnabled(false);
            }
            checkAvailability();
        }
        if (e.getActionCommand() == "<"){
            currentPlayerNumber--;
            displayPlayerDetails(currentPlayerNumber);
            nextButton.setEnabled(true);
            if(currentPlayerNumber == 0){
                previousButton.setEnabled(false);
            }
            checkAvailability();

        }
        if (e.getActionCommand() == "Team"){
            teamForm.setCurrentTeam(currentTeam);
            teamForm.show();
            frame.setVisible(false);
        }
        if (e.getActionCommand() == "Choose"){
            if(currentTeam == null){
                currentTeam = new FantasyBasketballTeam("Team 1");
                teamForm.setTeam(currentTeam);
            }
            if(currentTeam.isNotFull()) {
                currentTeam.addPlayer(testFantasy.getPlayer(currentPlayerNumber));
                testFantasy.setPlayerOwner(user, testFantasy.getPlayer(currentPlayerNumber));
                testFantasy.writePlayers("players.txt");
                teamForm.refresh();
                if (currentTeam.isFull()) {
                    chooseButton.setEnabled(false);

                }
            }
        }
    }

    private void displayPlayerDetails(int currentPlayerNumber){
        BasketballPlayer p = testFantasy.getPlayer(currentPlayerNumber);
        nameLabel.setText("Name: " + p.getName());
        positionLabel.setText("Position: " + p.getPos());
        pointLabel.setText("Points: " + Double.toString(p.getPoints()));
        reboundLabel.setText("Rebounds: " + Double.toString(p.getRebounds()));
        blockLabel.setText("Blocks: " + Double.toString(p.getBlock()));
        assistLabel.setText("Assists: " + Double.toString(p.getAssists()));
        stealLabel.setText("Steals: " + Double.toString(p.getSteals()));
        turnoverLabel.setText("Turnovers: " + Double.toString(p.getTurnover()));
        threepointLabel.setText("3P%: " + Double.toString(p.getThreepointpercentage()) + "%");
        freethrowLabel.setText("FT%: " + Double.toString(p.getFreethrowpercentage()) + "%");
        fieldgoalLabel.setText("FG%: " + Double.toString(p.getFieldgoalpercentage()) + "%");
        ownerLabel.setText("Owner: " + p.getOwner());

    }

    public void enableChoose(){
        chooseButton.setEnabled(true);
    }

    public void makeVisible(){
        frame.setVisible(true);
    }

    public boolean setUser(String u){
        user = u;
        return true;
    }

    public void checkAvailability(){
        if(testFantasy.getPlayer(currentPlayerNumber).getOwner().equals("None") == false){
            chooseButton.setEnabled(false);
        }else{
            chooseButton.setEnabled(true);
        }

    }

    public void buildTeam() {
        System.out.println(user);
        currentTeam = new FantasyBasketballTeam("Team");
        for (int i = 0; i < testFantasy.size(); i++) {
            if (testFantasy.getPlayer(i).getOwner().equals(user)) {
                currentTeam.addPlayer(testFantasy.getPlayer(i));
            }
        }
        if (currentTeam.isFull()) {
            chooseButton.setEnabled(false);

        }
    }

    public FantasyBasketballTeam getCurrentTeam () {
            return currentTeam;
        }

    }


