package com.company;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginGUI implements ActionListener, DocumentListener {

    ArrayList<String> user;
    ArrayList<String> password;

    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 250;
    private final int LEFT_MARGIN = 10;
    private final int TAB1 = 100;
    private final int TOP_MARGIN = 20;
    private final int BUTTON_Y = 150;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 40;
    private final int TEXT_WIDTH = 200;
    private final int TEXT_HEIGHT = 30;

    private JFrame frame;
    private LeagueGUI leagueGUI;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton confirmButton;
    private JLabel incorrectLabel;

    public LoginGUI(LeagueGUI leagueGUI, String loginFile) {
        this.leagueGUI = leagueGUI;

        frame = new JFrame("Login");

        // Field labels
        JLabel label1 = new JLabel("Username:");
        label1.setBounds(LEFT_MARGIN, TOP_MARGIN, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(label1);

        JLabel label2 = new JLabel("Password:");
        label2.setBounds(LEFT_MARGIN, TOP_MARGIN + TEXT_HEIGHT, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(label2);

        incorrectLabel = new JLabel("<html><font size='2' color=red> Incorrect Password </font></html>");
        incorrectLabel.setBounds(LEFT_MARGIN, TOP_MARGIN + TEXT_HEIGHT*2,TEXT_WIDTH, TEXT_HEIGHT);
        incorrectLabel.setEnabled(false);
        frame.add(incorrectLabel);

        // Input text
        usernameField = new JTextField();
        usernameField.setBounds(TAB1, TOP_MARGIN, TEXT_WIDTH, TEXT_HEIGHT);
        usernameField.getDocument().addDocumentListener(this);
        frame.add(usernameField);

        passwordField = new JPasswordField();
        passwordField.setBounds(TAB1, TOP_MARGIN + TEXT_HEIGHT, TEXT_WIDTH, TEXT_HEIGHT);
        passwordField.getDocument().addDocumentListener(this);
        frame.add(passwordField);

        //Confirm button which takes you to the GUI class
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(TAB1, BUTTON_Y, BUTTON_WIDTH * 2, BUTTON_HEIGHT);
        confirmButton.addActionListener(this);
        confirmButton.setEnabled(true);
        frame.add(confirmButton);

        // other frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);

        user = new ArrayList<>();
        password = new ArrayList<>();
        readUsers(loginFile);

    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Confirm"){

            int userFound = -1;
            for (int i = 0; i < user.size(); i++){
                if(user.get(i).equals(usernameField.getText())){
                    userFound = i ;
                }
            }
            String passwordText = new String(passwordField.getPassword());
            if(userFound != -1 && passwordText.equals(password.get(userFound))){
                leagueGUI.setUser(usernameField.getText());
                leagueGUI.makeVisible();
                leagueGUI.buildTeam();
                frame.setVisible(false);
            }else{
                incorrectLabel.setEnabled(true);
            }
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
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

    public void readUsers(String fileName) {
        ArrayList<String> allUsers;
        allUsers = FileHandling.readFileData(fileName);
        for (int i = 0; i < allUsers.size(); i++) {
            String[] rawUserFields = allUsers.get(i).split(",");
            if (rawUserFields.length == 2) {
                user.add(rawUserFields[0]);
                password.add(rawUserFields[1]);
            }

        }
    }



}
