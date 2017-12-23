package com.alma.pay2bid.gui.listeners;

import com.alma.pay2bid.client.IClient;
import com.alma.pay2bid.gui.AuctionView;
import com.alma.pay2bid.server.IServer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * An ActionListener called to raise the bid of an item
 * @author Alexis Giraudet
 * @author Arnaud Grall
 * @author Thomas Minier
 * Application corrigée et améliorée par Camille Le Luet, Asma Khelifi, François Hallereau, Sébastien Vallée et Sullivan Pineau
 */
public class RaiseBidButtonListener implements ActionListener {
    private IClient client;
    private IServer server;
    private AuctionView auctionView;
    private JTextField bidField;
    private JLabel statusLabel;

    public RaiseBidButtonListener(IClient client, IServer server, AuctionView gui, JLabel statusLabel) {
        this.client = client;
        this.server = server;
        auctionView = gui;
        this.bidField = gui.getAuctionBid();
        this.statusLabel = statusLabel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        if("raiseBid".equals(command))  {
            int newPrice = Integer.parseInt(bidField.getText());
            int currentPrice = Integer.parseInt(auctionView.getPrice());
            if(newPrice>currentPrice){
                try {
                    server.raiseBid(client, Integer.valueOf(bidField.getText()));
                    statusLabel.setText("New bid sent.");
                    auctionView.disable();
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (Exception e2){
                    statusLabel.setText("Price must be an Integer");
                }
            }
        }
    }
}
