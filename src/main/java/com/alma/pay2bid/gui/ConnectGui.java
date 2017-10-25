package com.alma.pay2bid.gui;

import com.alma.pay2bid.client.Client;
import com.alma.pay2bid.server.IServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class ConnectGui{

    private Client client;
    private IServer server;
    private JFrame frame;

    public ConnectGui(Client client, IServer server){
        this.client = client;
        this.server = server;


        if(this.client == null && this.server == null){
            draw();
        }
        else{
            try {
                ClientGui c = new ClientGui(client,server);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw(){
        frame = new JFrame("Pay 2 Bid");
        Dimension dimension = new Dimension(500, 500);
        frame.setSize(500, 500);
        frame.setMaximumSize(dimension);
        frame.setLayout(new BorderLayout());

        JLabel statusLabel = new JLabel("Echec de la connexion au serveur",
                JLabel.CENTER);
        statusLabel.setBackground(Color.red);
        statusLabel.setSize(400,0);
        frame.add(statusLabel,BorderLayout.CENTER);

        JButton connect = new JButton("Se Connecter");
        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    server = (IServer) LocateRegistry.getRegistry("localhost", 1099)
                            .lookup("com.alma.pay2bid.server.Server");

                    client = new Client(server, "Client " + "localhost");

                    ClientGui c = new ClientGui(client,server);
                    c.show();
                    frame.dispose();

                } catch (ConnectException ec){
                    System.err.println("Echec de la connexion");
                    server = null;
                    client = null;
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        frame.add(connect,BorderLayout.PAGE_END);
        frame.setVisible(true);

    }

}
