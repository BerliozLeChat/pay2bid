package com.alma.pay2bid.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Folkvir(Grall Arnaud)) on 28/09/16.
 */
public class ClientGui {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    /**
     * Constructor
     */
    public ClientGui(){
        createGui();
    }

    private void createGui(){
        mainFrame = new JFrame("Pay2Bid - Auction");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);

        statusLabel.setSize(350,100);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void prepareView(){
        headerLabel.setText("Control in action: Button");

        JButton okButton = new JButton("newAuction");
        JButton submitButton = new JButton("raiseBid");
        //

        okButton.setActionCommand("newAuction");
        submitButton.setActionCommand("raiseBid");
        //cancelButton.setActionCommand("Cancel");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        //cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        //controlPanel.add(cancelButton);

        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if( command.equals( "newAuction" ))  {
                statusLabel.setText("New Auction sent.");
            }
            else if( command.equals( "raiseBid" ) )  {
                statusLabel.setText("New bid sent.");
            }
        }
    }

    public static void main(String[] args){
        ClientGui c = new ClientGui();
        c.prepareView();
    }
}
