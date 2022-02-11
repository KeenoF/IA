package com.company;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StandingGUI implements ActionListener {
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

    public StandingGUI(FantasyLeague fantasyleague, TeamGUI teamForm ) {
        this.testFantasy = fantasyleague;
        this.teamForm = teamForm;
        this.currentTeam = null;
        frame = new JFrame("Standing");

        //Field Labels



        //Back Button takes you back to the main GUI which shows you the whole league
        backButton = new JButton("Back");
        backButton.setBounds(LEFT_MARGIN, BUTTON_Y + BUTTON_HEIGHT,BUTTON_WIDTH,BUTTON_HEIGHT);
        backButton.addActionListener(this);
        backButton.setEnabled(true);
        frame.add(backButton);

        // other frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(false);

    }

    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Back"){
            teamForm.show();
            frame.setVisible(false);
        }

    }

}

