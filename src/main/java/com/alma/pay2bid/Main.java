package com.alma.pay2bid;

import com.alma.pay2bid.gui.Identification;
import com.alma.pay2bid.server.IServer;
import com.alma.pay2bid.server.Server;
import org.apache.commons.cli.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

/**
 * The Main application
 * @author Alexis Giraudet
 * @author Arnaud Grall
 * @author Thomas Minier
 * Application corrigée et améliorée par Camille Le Luet, Asma Khelifi, François Hallereau, Sébastien Vallée et Sullivan Pineau
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Server.class.getCanonicalName());

    private static void startClient(String host, int port) {
            Identification identification = new Identification( host, port);
    }

    private static void startServer(int port, boolean daemon) {
        try {
            String name = "com.alma.pay2bid.server.Server";
            IServer server = new Server();
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind(name, server);
            LOGGER.info("Server up and running at localhost on port " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Options options = new Options();

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "pay2bid", options );

        options.addOption("l", "listen", false, "server port to listen");
        options.addOption("d", "daemon", false, "run the server as a daemon");
        options.addOption("h", "host", false, "host");
        options.addOption("p", "daemon", false, "port");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        String host = "localhost";
        int port = 1099;
        boolean daemon = false;

        if(cmd.hasOption("d")) {
            daemon = true;
        }

        if(cmd.hasOption("h") && cmd.getOptionValue("h") != null) {
            host = cmd.getOptionValue("h");
        }

        if(cmd.hasOption("p") && cmd.getOptionValue("p") != null) {
            port = Integer.parseInt(cmd.getOptionValue("p"));
        }

        if(cmd.hasOption("l")) {
            // start the server
            startServer(port, daemon);
        } else {
            // start client gui
            startClient(host, port);
        }
    }
}
