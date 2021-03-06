package com.alma.pay2bid.gui;

import com.alma.pay2bid.bean.AuctionBean;

import javax.swing.*;
import java.awt.*;

/**
 * The widget used to display an auction
 * @author Alexis Giraudet
 * @author Arnaud Grall
 * @author Thomas Minier
 * Application corrigée et améliorée par Camille Le Luet, Asma Khelifi, François Hallereau, Sébastien Vallée et Sullivan Pineau
 */
public class AuctionView {

    /**
     * Properties for the main panel
     */
    private JPanel auctionPanel;
    private JLabel auctionPriceValue;
    private JLabel auctionTimer;
    private JTextField auctionBid;
    private JLabel auctionBidLabel;
    private JButton raiseButton;
    private boolean finish = false;

    public AuctionView(AuctionBean auction){
        auctionPanel = new JPanel();
        auctionPanel.setMaximumSize(new Dimension(500, 150));
        auctionPanel.setLayout(new GridLayout(4, 3, 5, 5));

        // Create the price label
        JLabel auctionPriceLabel = new JLabel(" Price : ");
        auctionPriceValue = new JLabel("");
        auctionPriceValue.setText(Integer.toString(auction.getPrice()));
        auctionPriceValue.setLabelFor(auctionPriceLabel);
        auctionPanel.add(auctionPriceLabel);
        auctionPanel.add(auctionPriceValue);

        // Create the bid field
        auctionBid = new JTextField("", JLabel.TRAILING);
        auctionBidLabel = new JLabel("New Price : ");

        auctionBidLabel.setLabelFor(auctionBid);
        auctionPanel.add(auctionBidLabel);
        auctionPanel.add(auctionBid);
        auctionPanel.setBorder(BorderFactory.createTitledBorder(auction.getName()));

        //Create the timer label
        auctionTimer = new JLabel("0");
        JLabel auctionTimerLabel = new JLabel("Remaining time : ");
        auctionTimer.setLabelFor(auctionTimerLabel);
        auctionPanel.add(auctionTimerLabel);
        auctionPanel.add(auctionTimer);
    }

    public void enable() {
        if(!finish){
            auctionBid.setVisible(true);
            auctionBidLabel.setVisible(true);
            raiseButton.setVisible(true);
        }
    }

    public void disable() {
        // remove the input elements
        auctionBid.setVisible(false);
        auctionBidLabel.setVisible(false);
        raiseButton.setVisible(false);
    }

    public void setWinner(String name) {
        if(!finish){
            auctionBidLabel.setText("Winner : " + name);
            auctionBidLabel.setVisible(true);
            auctionBid.setVisible(false);
            raiseButton.setVisible(false);
            auctionTimer.getLabelFor().setVisible(false);
            auctionTimer.setVisible(false);
            finish=true;
        }
    }

    public void setRaiseButton(JButton raiseButton) {
        this.raiseButton = raiseButton;
        auctionPanel.add(raiseButton, 6);
    }

    public void setPrice(int newPrice){
        auctionPriceValue.setText(String.valueOf(newPrice));
    }

    public String getPrice(){
        return auctionPriceValue.getText();
    }

    public JTextField getAuctionBid() {
        return auctionBid;
    }

    public JPanel getAuctionPanel() {
        return auctionPanel;
    }

    public void setAuctionTimer(String time) {
        if(!finish){
            this.auctionTimer.setText(time);
        }
    }
}
