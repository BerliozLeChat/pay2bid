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
public class Identification {
    private Client client;
    private IServer server;
    private String host;
    private int port;
    private JFrame frame;
    private JTextField  name_user;
    private ClientGui c;

    public Identification(String host, int port){
        this.host = host;
        this.port = port;
        draw();
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
                        frame.dispose();
                        server = (IServer) LocateRegistry.getRegistry(host, port)
                                .lookup("com.alma.pay2bid.server.Server");

                        client = new Client(server, name_user.getText());
                        c = new ClientGui(client, server);
                        c.show();
                    } catch (ConnectException ex){
                        System.err.println("Echec de la connexion ");
                        ConnectGui con = new ConnectGui(null, null, name_user.getText());
                    }catch (Exception ey) {
                        ey.printStackTrace();
                    }
                }
            }
        });

        frame.add(connect,BorderLayout.PAGE_END);
        frame.setVisible(true);
    }

}
