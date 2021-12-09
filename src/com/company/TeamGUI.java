package com.company;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamGUI implements ActionListener, DocumentListener {
    private int currentPlayerNumber;
    private FantasyLeague testfantasy;
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

    private JFrame frame;
    private GUI mainGUI;
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
    private JButton backButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton removeButton;


    public TeamGUI(FantasyLeague fantasyleague, GUI mainGUI) {
        this.testfantasy = fantasyleague;
        this.mainGUI = mainGUI;
        this.currentTeam = null;
        frame = new JFrame("Team");

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


        //Previous Button
        previousButton = new JButton("<");
        previousButton.setBounds(LEFT_MARGIN, BUTTON_Y,BUTTON_WIDTH,BUTTON_HEIGHT);
        previousButton.addActionListener(this);
        previousButton.setEnabled(false);
        frame.add(previousButton);

        //Next Button
        nextButton = new JButton(">");
        nextButton.setBounds(LEFT_MARGIN + BUTTON_WIDTH, BUTTON_Y, BUTTON_WIDTH,BUTTON_HEIGHT);
        nextButton.addActionListener(this);
        nextButton.setEnabled(true);
        frame.add(nextButton);

        //Back Button takes you back to the main GUI which shows you the whole league
        backButton = new JButton("Back");
        backButton.setBounds(LEFT_MARGIN, BUTTON_Y + BUTTON_HEIGHT,BUTTON_WIDTH,BUTTON_HEIGHT);
        backButton.addActionListener(this);
        backButton.setEnabled(true);
        frame.add(backButton);

        removeButton = new JButton("Remove");
        removeButton.setBounds(LEFT_MARGIN + BUTTON_WIDTH, BUTTON_Y + BUTTON_HEIGHT,BUTTON_WIDTH,BUTTON_HEIGHT);
        removeButton.addActionListener(this);
        removeButton.setEnabled(true);
        frame.add(removeButton);

        // other frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(false);

        //displayPlayerDetails(currentPlayerNumber);


    }

    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "<"){
            currentPlayerNumber--;
            displayPlayerDetails(currentPlayerNumber);
            nextButton.setEnabled(true);
            if (currentPlayerNumber == 0){
                previousButton.setEnabled(false);
            }
        }

        if (e.getActionCommand() == ">"){
            if (currentPlayerNumber >= currentTeam.playerCount()-1){
                nextButton.setEnabled(false);
            }else{
                currentPlayerNumber++;
            }
            displayPlayerDetails(currentPlayerNumber);
            previousButton.setEnabled(true);
            System.out.println(currentPlayerNumber + "," + currentTeam.playerCount());
        }

        if (e.getActionCommand() == "Back"){
            mainGUI.makeVisible();
            frame.setVisible(false);
        }

        if (e.getActionCommand() == "Remove"){
            for(int i = 0; i < currentTeam.getTeamSize(); i++ ){
                System.out.println(currentTeam.getTeamSize());
            }
            currentTeam.removePlayer(currentTeam.getPlayer(currentPlayerNumber));
            for(int i = 0; i < currentTeam.getTeamSize(); i++ ){
            }
            mainGUI.enableChoose();
            currentTeam.displayTeam();
            System.out.println(currentPlayerNumber);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // triggers when the style of the text changes
        System.out.println("change!");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("remove!");
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println("insert! ");
    }

    private void displayPlayerDetails(int currentPlayerNumber){
        if (currentTeam != null && currentPlayerNumber < currentTeam.getTeamSize()){
            BasketballPlayer p = currentTeam.getPlayer(currentPlayerNumber);
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

    }

    public void setTeam(FantasyBasketballTeam t){
        currentTeam = t;
    }

    public void refresh(){
        displayPlayerDetails(currentPlayerNumber);
    }

}

