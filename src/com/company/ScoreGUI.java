package com.company;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScoreGUI implements ActionListener {
    private int currentPlayerNumber;
    private FantasyLeague testFantasy;
    private FantasyBasketballTeam currentTeam;

    private final int FRAME_WIDTH = 450;
    private final int FRAME_HEIGHT = 200;
    private final int LEFT_MARGIN = 100;
    private final int TOP_MARGIN = 20;
    private final int BUTTON_Y = 50;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 40;
    private final int TEXT_WIDTH = 200;
    private final int TEXT_HEIGHT = 30;

    private JFrame frame;
    private TeamGUI teamForm;
    private JLabel scoreLabel;
    private JButton backButton;

    public ScoreGUI(FantasyLeague fantasyleague, TeamGUI teamForm) {
        this.testFantasy = fantasyleague;
        this.teamForm = teamForm;
        this.currentTeam = null;
        frame = new JFrame("Score");

        //Field Labels
        scoreLabel = new JLabel("Score:");
        scoreLabel.setBounds(LEFT_MARGIN, TOP_MARGIN, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(scoreLabel);


        //Back Button takes you back to the main GUI which shows you the whole league
        backButton = new JButton("Back");
        backButton.setBounds(LEFT_MARGIN, BUTTON_Y + BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
        backButton.addActionListener(this);
        backButton.setEnabled(true);
        frame.add(backButton);

        // other frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(false);

        displayScore();

    }

    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Back") {
            teamForm.show();
            frame.setVisible(false);
        }
    }

    public void displayScore(){
        scoreLabel.setText("Score: " + overallScore());
    }

    public void refreshScore(){
        overallScore();
    }

    public int overallScore() {
        int overallscore = 0;
        for (int i = 0; i < testFantasy.size(); i++) {
            if (testFantasy.getPlayer(i).getPoints() <= 10 ){
                overallscore = overallscore + 1;
            }else if (testFantasy.getPlayer(i).getPoints() > 10 && testFantasy.getPlayer(i).getPoints() <= 20) {
                overallscore = overallscore + 3;
            } else if (testFantasy.getPlayer(i).getPoints() > 20 && testFantasy.getPlayer(i).getPoints() <= 30) {
                overallscore = overallscore + 5;
            } else if (testFantasy.getPlayer(i).getPoints() < 40) {
                overallscore = overallscore + 10;
            }
            if (testFantasy.getPlayer(i).getAssists() <= 5) {
                overallscore = overallscore + 1;
            } else if (testFantasy.getPlayer(i).getAssists() > 5 && testFantasy.getPlayer(i).getAssists() <= 10) {
                overallscore = overallscore + 3;
            } else if (testFantasy.getPlayer(i).getAssists() > 10 && testFantasy.getPlayer(i).getAssists() <= 15) {
                overallscore = overallscore + 5;
            } else if (testFantasy.getPlayer(i).getAssists() < 15) {
                overallscore = overallscore + 10;
            }
            if (testFantasy.getPlayer(i).getRebounds() <= 3) {
                overallscore = overallscore + 1;
            } else if (testFantasy.getPlayer(i).getRebounds() > 3 && testFantasy.getPlayer(i).getRebounds() <= 7) {
                overallscore = overallscore + 3;
            } else if (testFantasy.getPlayer(i).getRebounds() > 7 && testFantasy.getPlayer(i).getRebounds() <= 10) {
                overallscore = overallscore + 5;
            } else if (testFantasy.getPlayer(i).getRebounds() < 10) {
                overallscore = overallscore + 10;
            }
            if (testFantasy.getPlayer(i).getBlock() <= 3) {
                overallscore = overallscore + 1;
            } else if (testFantasy.getPlayer(i).getBlock() > 3 && testFantasy.getPlayer(i).getBlock() <= 6) {
                overallscore = overallscore + 3;
            } else if (testFantasy.getPlayer(i).getBlock() > 6 && testFantasy.getPlayer(i).getBlock() <= 9) {
                overallscore = overallscore + 5;
            } else if (testFantasy.getPlayer(i).getBlock() < 9) {
                overallscore = overallscore + 10;
            }
            if (testFantasy.getPlayer(i).getSteals() <= 3) {
                overallscore = overallscore + 1;
            } else if (testFantasy.getPlayer(i).getSteals() > 3 && testFantasy.getPlayer(i).getSteals() <= 6) {
                overallscore = overallscore + 3;
            } else if (testFantasy.getPlayer(i).getSteals() > 6 && testFantasy.getPlayer(i).getSteals() <= 9) {
                overallscore = overallscore + 5;
            } else if (testFantasy.getPlayer(i).getSteals() < 9) {
                overallscore = overallscore + 10;
            }
            if (testFantasy.getPlayer(i).getTurnover() == 0) {
                overallscore = overallscore;
            } else if (testFantasy.getPlayer(i).getTurnover() >= 1 && testFantasy.getPlayer(i).getTurnover() <= 4) {
                overallscore = overallscore - 2;
            } else if (testFantasy.getPlayer(i).getTurnover() > 4 && testFantasy.getPlayer(i).getTurnover() <= 9) {
                overallscore = overallscore - 5;
            } else if (testFantasy.getPlayer(i).getTurnover() < 9) {
                overallscore = overallscore - 10;
            }
            if (testFantasy.getPlayer(i).getThreepointpercentage() <= 20) {
                overallscore = overallscore + 1;
            } else if (testFantasy.getPlayer(i).getThreepointpercentage() > 20 && testFantasy.getPlayer(i).getThreepointpercentage() <= 40) {
                overallscore = overallscore + 2;
            } else if (testFantasy.getPlayer(i).getThreepointpercentage() > 40 && testFantasy.getPlayer(i).getThreepointpercentage() <= 60) {
                overallscore = overallscore + 5;
            } else if (testFantasy.getPlayer(i).getThreepointpercentage() < 60) {
                overallscore = overallscore + 10;
            }
            if (testFantasy.getPlayer(i).getThreepointpercentage() <= 20) {
                overallscore = overallscore + 1;
            } else if (testFantasy.getPlayer(i).getThreepointpercentage() > 20 && testFantasy.getPlayer(i).getThreepointpercentage() <= 40) {
                overallscore = overallscore + 2;
            } else if (testFantasy.getPlayer(i).getThreepointpercentage() > 40 && testFantasy.getPlayer(i).getThreepointpercentage() <= 60) {
                overallscore = overallscore + 5;
            } else if (testFantasy.getPlayer(i).getThreepointpercentage() < 60) {
                overallscore = overallscore + 10;
            }
        }
        return overallscore;
    }
}