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

/**
 * The widget used to manage authentication
 * @author Camille Le Luet
 * @author Asma Khelifi
 * @author François Hallereau
 * @author Sébastien Vallée
 * @author Sullivan Pineau
 */
public class Authentification {
    private Client client;
    private IServer server;
    private JFrame frame;
    private JTextField  name_user;

    public Authentification(Client client, IServer server){
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
                ConnectGui  con = new ConnectGui(null,null, name_user.getText());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw(){
        frame = new JFrame("Pay 2 Bid");
        JPanel panel = new JPanel();
        frame.setSize(new Dimension(500, 200));

        JLabel nameLabel = new JLabel("Pseudo : ");
        name_user = new JTextField("");
        name_user.setPreferredSize(new Dimension(150,30));

        panel.add(nameLabel);
        panel.add(name_user);
        JPanel container = new JPanel();
        container.add(panel, BorderLayout.NORTH);
        frame.setContentPane(container);
        frame.setVisible(true);

        JButton connect = new JButton("Se Connecter");
        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!name_user.getText().equals("")) {
                    try {
                        server = (IServer) LocateRegistry.getRegistry("localhost", 1099)
                                .lookup("com.alma.pay2bid.server.Server");

                        client = new Client(server, name_user.getText());
                        ClientGui c = new ClientGui(client, server);
                        c.show();
                        frame.dispose();

                    } catch (ConnectException ec) {
                        ConnectGui con = new ConnectGui(null, null, name_user.getText());
                    } catch (Exception ex) {

                        ex.printStackTrace();
                    }
                }
            }
        });

        frame.add(connect,BorderLayout.PAGE_END);
        frame.setVisible(true);
    }

}
